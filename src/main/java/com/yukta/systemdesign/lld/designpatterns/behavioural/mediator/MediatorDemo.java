package com.yukta.systemdesign.lld.designpatterns.behavioural.mediator;

import java.util.*;

// ─────────────── Mediator Interface ───────────────
interface IMediator {

    void registerColleague(Colleague c);

    void send(String from, String msg);

    void sendPrivate(String from, String to, String msg);
}

// ─────────────── Colleague Abstract Class ───────────────
abstract class Colleague {

    protected IMediator mediator;

    public Colleague(IMediator mediator) {
        this.mediator = mediator;
        mediator.registerColleague(this);
    }

    abstract String getName();

    abstract void send(String msg);

    abstract void sendPrivate(String to, String msg);

    abstract void receive(String from, String msg);
}

// ─────────────── Concrete Mediator ───────────────
class ChatMediator implements IMediator {

    private List<Colleague> colleagues = new ArrayList<>();

    // (muter, muted)
    private List<AbstractMap.SimpleEntry<String, String>> mutes =
            new ArrayList<>();

    @Override
    public void registerColleague(Colleague c) {
        colleagues.add(c);
    }

    public void mute(String who, String whom) {
        mutes.add(new AbstractMap.SimpleEntry<>(who, whom));
    }

    @Override
    public void send(String from, String msg) {

        System.out.println("[" + from + " broadcasts]: " + msg);

        for (Colleague c : colleagues) {

            // Don't send to self
            if (c.getName().equals(from)) {
                continue;
            }

            boolean isMuted = false;

            for (AbstractMap.SimpleEntry<String, String> p : mutes) {

                // receiver muted sender
                if (from.equals(p.getValue())
                        && c.getName().equals(p.getKey())) {

                    isMuted = true;
                    break;
                }
            }

            if (!isMuted) {
                c.receive(from, msg);
            }
        }
    }

    @Override
    public void sendPrivate(String from, String to, String msg) {

        System.out.println("[" + from + " → " + to + "]: " + msg);

        for (Colleague c : colleagues) {

            if (c.getName().equals(to)) {

                for (AbstractMap.SimpleEntry<String, String> p : mutes) {

                    // receiver muted sender
                    if (from.equals(p.getValue())
                            && to.equals(p.getKey())) {

                        System.out.println("[Message is muted]");
                        return;
                    }
                }

                c.receive(from, msg);
                return;
            }
        }

        System.out.println("[Mediator] User \"" + to + "\" not found");
    }
}

// ─────────────── Concrete Colleague ───────────────
class User1 extends Colleague {

    private String name;

    public User1(String name, IMediator mediator) {
        super(mediator);
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void send(String msg) {
        mediator.send(name, msg);
    }

    @Override
    void sendPrivate(String to, String msg) {
        mediator.sendPrivate(name, to, msg);
    }

    @Override
    void receive(String from, String msg) {

        System.out.println(
                "    " + name + " got from " + from + ": " + msg
        );
    }
}

// ─────────────── Demo ───────────────
public class MediatorDemo {

    public static void main(String[] args) {

        ChatMediator chatRoom = new ChatMediator();

        User1 user1 = new User1("Rohan", chatRoom);
        User1 user2 = new User1("Neha", chatRoom);
        User1 user3 = new User1("Mohan", chatRoom);

        // Rohan mutes Mohan
        chatRoom.mute("Rohan", "Mohan");

        // Broadcast from Rohan
        user1.send("Hello Everyone!");

        System.out.println();

        // Private from Mohan to Neha
        user3.sendPrivate("Neha", "Hey Neha!");

        System.out.println();

        // Private from Mohan to Rohan (muted)
        user3.sendPrivate("Rohan", "Hello Rohan!");
    }
}
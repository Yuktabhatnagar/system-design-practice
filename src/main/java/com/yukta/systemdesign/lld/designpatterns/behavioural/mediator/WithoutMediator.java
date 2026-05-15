package com.yukta.systemdesign.lld.designpatterns.behavioural.mediator;

import java.util.*;

//Each user knows all the others directly
//If you have n users, you wind up wiring N*(N-1)/2 connections.
//and every new feature (mute, private send, logging.... ) lives in User too

// Class representing a User in a collaborative document editor.
class User {
    private String name;
    private List<User> others;  // List of users that have access to this user
    private List<User> mutedUsers;

    // Constructor for creating a User with a name.
    public User(String name) {
        this.name = name;
        this.others = new ArrayList<>();
        this.mutedUsers = new ArrayList<>();
    }

    // Method to add a collaborator to this user (grants access to the user). N^2 wiring
    public void addCollaborator(User user) {
        others.add(user);
    }

    public void mute(User user) {
        mutedUsers.add(user);
    }

    void send(String msg) {
        System.out.println("[" + name + " broadcasts]: "+ msg );
        for (User user1 : others) {

            // if they have muted me don't send.
            if(!user1.isMuted(this)) {
                user1.receiveChange(msg, this);
            }
        }
    }

    public boolean isMuted(User userName) {
        for(User u1 : mutedUsers) {
            if(u1.equals(userName) ){
                return true;
            }
        }
        return false;
    }

    void receive(String from, String msg) {
        System.out.println("    " + name + " got from " +from + ": " + msg );
    }

    // Method to make a change to the document and notify all collaborators.
    // Each collaborator will receive the change notification.
    public void makeChange(String change) {
        System.out.println(name + " made a change: " + change);
        for (User u : others) {
            u.receiveChange(change, this);  // Notify each collaborator about the change.
        }
    }

    // Method to receive a change notification from another user.
    public void receiveChange(String change, User from) {
        System.out.println(name + " received: \"" + change + "\" from " + from.name);
    }

    // private send - duplicated in every class
    void sendTo(User target, String msg) {
        System.out.println("[" + name + "→" + target.name + "]: " + msg);
        if(!target.isMuted(this)) {
            target.receiveChange(msg, this);
        }
    }
}


// Client Code
public class WithoutMediator {
    public static void main(String[] args) {
        // Creating users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // Adding collaborators (Alice gives access to Bob and Charlie)
        alice.addCollaborator(bob);
        alice.addCollaborator(charlie);

        bob.addCollaborator(alice);
        bob.addCollaborator(charlie);

        charlie.addCollaborator(bob);
        charlie.addCollaborator(alice);

        // mute example: Alice mutes Bob (Bob added to Alice's muted list).
        alice.mute(bob);

        // broadcast
        alice.send("Hello Everyone!");
        bob.send("Hey Buddy!");

        // private
        charlie.sendTo(bob, "Hey Bob!");

        // Alice makes a change, notifying Bob and Charlie
        alice.makeChange("Updated the document title");

        // Bob makes a change, but no collaborators are notified because Bob has no collaborators added
        bob.makeChange("Added a new section to the document");

    }
}

package com.yukta.systemdesign.lld.designpatterns.behavioural.NullObjectPattern;

// Common Interface
interface Customer {
    String getName();
    boolean isNull();
}

// Real Object
class RealCustomer implements Customer {

    private String name;

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}

// Null Object
class NullCustomer implements Customer {

    @Override
    public String getName() {
        return "Guest User";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}

// Factory
class CustomerFactory {

    private static final String[] validUsers =
            {"Yukta", "Rohan", "Neha"};

    public static Customer getCustomer(String name) {

        for (String user : validUsers) {

            if (user.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }

        // return safe default object instead of null
        return new NullCustomer();
    }
}

// Client
public class NullObjectPatternDemo {

    public static void main(String[] args) {

        Customer c1 =
                CustomerFactory.getCustomer("Yukta");

        Customer c2 =
                CustomerFactory.getCustomer("Unknown");

        System.out.println(c1.getName());
        System.out.println(c2.getName());

        System.out.println(c1.isNull());
        System.out.println(c2.isNull());
    }
}

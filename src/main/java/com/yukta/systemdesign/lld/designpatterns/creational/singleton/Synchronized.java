package com.yukta.systemdesign.lld.designpatterns.creational.singleton;

public class Synchronized {
    // Object declaration
    private static Synchronized instance;

    // Private constructor
    private Synchronized() {}

    // Synchronized keyword used
    public static synchronized Synchronized getInstance() {
        if (instance == null) {
            instance = new Synchronized();
        }
        return instance;
    }
}


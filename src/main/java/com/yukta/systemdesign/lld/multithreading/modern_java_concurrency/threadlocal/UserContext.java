package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.threadlocal;

public class UserContext {

    private static final ThreadLocal<String>
            currentUser =
            new ThreadLocal<>();

    public static void setUser(
            String user) {

        currentUser.set(user);
    }

    public static String getUser() {

        return currentUser.get();
    }
}
/*

Controller:

        UserContext.setUser("Yukta");

Service:

        System.out.println(
        UserContext.getUser()
);
*/

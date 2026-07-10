package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class KISS {
//    Uses extra variables, unnecessary if-else logic and Makes the code longer and harder to follow.
    public static boolean isEvenNo(int number) {
        // Using unnecessary logic to determine evenness
        boolean isEven = false;

        if (number % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }

        return isEven;
    }

//Simple, one-liner solution, Easy to read and understand. Avoids overengineering.
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

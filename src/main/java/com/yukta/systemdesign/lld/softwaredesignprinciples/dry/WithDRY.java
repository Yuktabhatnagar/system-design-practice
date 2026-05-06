package com.yukta.systemdesign.lld.softwaredesignprinciples.dry;

class AreaCalculator {
    public static int calculateArea(int length, int width) {
        return length * width;
    }
}

public class WithDRY {
    public static void main(String[] args) {
        int area1 = AreaCalculator.calculateArea(10, 5);
        int area2 = AreaCalculator.calculateArea(8, 4);

        System.out.println("Area1: " + area1);
        System.out.println("Area2: " + area2);
    }
}

package com.yukta.systemdesign.lld.softwaredesignprinciples.dry;

public class WithoutDRY {
    public static void main(String[] args) {
        int length1 = 10, width1 = 5;
        int area1 = length1 * width1;
        System.out.println("Area1: " + area1);

        int length2 = 8, width2 = 4;
        int area2 = length2 * width2;
        System.out.println("Area2: " + area2);
    }
}

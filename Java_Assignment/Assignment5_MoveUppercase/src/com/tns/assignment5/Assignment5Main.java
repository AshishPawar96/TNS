package com.tns.assignment5;

import java.util.Scanner;

public class Assignment5Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String str = sc.nextLine();

        StringBuilder remaining = new StringBuilder();
        StringBuilder uppercase = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {
                uppercase.append(ch);
            } else {
                remaining.append(ch);
            }
        }

        String result = remaining.toString() + uppercase.toString();

        System.out.println("Modified String: " + result);

        sc.close();
    }
}
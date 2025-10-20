package com.task1;

import java.util.Scanner;

public class Calculator {

    static float add(float a, float b) {
        return a + b;
    }

    static float subtract(float a, float b) {
        return a - b;
    }

    static float multiply(float a, float b) {
        return a * b;
    }
    static float division(float a, float b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Float.NaN;
        }
        return a / b;
    }

    static float readFloat(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextFloat()) {
                return sc.nextFloat();
            } else {
                System.out.println("Error: Please enter a valid number!");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose operation: +, -, *, / or x to exit");
            String operation = sc.next();

            if (operation.equalsIgnoreCase("x")) {
                System.out.println("Exiting...");
                break;
            }
            if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                System.out.println("Invalid operation! Try again.");
                continue;
            }
            float a = readFloat(sc, "Enter first number: ");
            float b = readFloat(sc, "Enter second number: ");

            switch (operation) {
                case "+":
                    System.out.println("Result: " + add(a, b));
                    break;
                case "-":
                    System.out.println("Result: " + subtract(a, b));
                    break;
                case "*":
                    System.out.println("Result: " + multiply(a, b));
                    break;
                case "/":
                    float division = division(a, b);
                    if (!Float.isNaN(division)) {
                        System.out.println("Result: " + division);
                    }
                    break;
            }

        }
        sc.close();
    }
}
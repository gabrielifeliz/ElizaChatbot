package com.company;

// Import Random and Scanner classes
import java.util.Random;
import java.util.Scanner;

public class ElizaChatbot {

    public static void main(String[] args) {

        // Create Random and Scanner objects
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        String answer = "";
        String[] hedges = {"Please tell me more.",
                "Many of my patients tell me the same thing."},
                qualifiers = {"Why do you say that ",
                        "You seem to think that ",
                        "So, you are concerned that "};

        System.out.print("Good day. What is your problem? Enter your response here or Q to quit: ");
        answer = keyboard.nextLine();

        int loopCount = 0;
        while (!(answer.equalsIgnoreCase("Q"))) {

            if (loopCount == 6) {
                System.out.print("It is getting late, maybe we had better quit."
                        + " Enter your response here or Q to quit: ");
                answer = keyboard.nextLine();
            } else {
                if (random.nextInt(2) == 1) {
                    System.out.println(hedges[random.nextInt(hedges.length)]
                            + " Enter your response here or Q to quit: ");
                    answer = keyboard.nextLine();
                } else {
                    System.out.println(qualifiers[random.nextInt(qualifiers.length)]
                            + splitSentence(answer) + " Enter your response here or Q to quit: ");
                    answer = keyboard.nextLine();
                }
            }
            loopCount++;
        }
    }

    public static String splitSentence(String message) {

        String newSentence = "";
        String[] response = message.split(" ");
        for (int i = 0; i < response.length; i++) {
            if (response[i].equalsIgnoreCase("I")) {
                response[i] = "you";
            } else if (response[i].equalsIgnoreCase("me")) {
                response[i] = "you";
            } else if (response[i].equalsIgnoreCase("my")) {
                response[i] = "your";
            } else if (response[i].equalsIgnoreCase("am")) {
                response[i] = "are";
            }

            if (i == response.length - 1) {
                newSentence += response[i] + ".";
            } else {
                newSentence += response[i] + " ";
            }
        }

        return newSentence;
    }
}

package com.company;

// Import Random and Scanner classes
import java.util.Random;
import java.util.Scanner;

public class ElizaChatbot {

    public static void main(String[] args) {

        // Create Random and Scanner objects
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // Initialize answer to an empty string
        String answer = "";
        // Initialize two String arrays sentences to create dialogue with the user
        String[] hedges = {"Please tell me more.",
                "Many of my patients tell me the same thing."},
                qualifiers = {"Why do you say that ",
                        "You seem to think that ",
                        "So, you are concerned that "};

        // Prompt the user to enter his or her problem and get the response
        System.out.print("Good day. What is your problem? Enter your response here or Q to quit: ");
        answer = keyboard.nextLine();

        // Initialize loop count to zero
        int loopCount = 0;
        // Continue the dialogue between Eliza and the user until the user enter Q or q
        while (!(answer.equalsIgnoreCase("Q"))) {
            // Create dialogues with the user if the loop count is not 8
            if (loopCount != 8) {
                if (random.nextInt(2) == 1) {
                    System.out.println(hedges[random.nextInt(hedges.length)]
                            + " Enter your response here or Q to quit: ");
                    answer = keyboard.nextLine();
                } else {
                    System.out.println(qualifiers[random.nextInt(qualifiers.length)]
                            + splitSentence(answer) + " Enter your response here or Q to quit: ");
                    answer = keyboard.nextLine();
                }
            } else {
				/* If the loop counts gets to 8,
					the "chat-bot" breaks the while loop and terminates the program */
                System.out.print("It is getting late, maybe we had better quit.");
                break;
            }
            loopCount++;
        }

        keyboard.close();
    }

    /* This method is responsible for splitting firs-person sentence
        and returns a second-person sentence */
    public static String splitSentence(String message) {

        // Initialize new sentence to empty string
        String newSentence = "";
        // Convert the first-person sentence into an array of words using split
        String[] response = message.split(" ");
        for (int i = 0; i < response.length; i++) {

            // Change first person to third person with if-else statements
            if (response[i].equalsIgnoreCase("I")) {
                response[i] = "you";
            } else if (response[i].equalsIgnoreCase("me")) {
                response[i] = "you";
            } else if (response[i].equalsIgnoreCase("my")) {
                response[i] = "your";
            } else if (response[i].equalsIgnoreCase("am")) {
                response[i] = "are";
            }

            // Add words separated by spaces if it's not the last word
            if (i != response.length - 1) {
                newSentence += response[i] + " ";
            } else {
                // Add last word, ending with a period
                newSentence += response[i] + ".";
            }
        }
        return newSentence;
    }
}
/*
 * Author:  Matthew Yeend
 * Project: Simple Quiz
 * Version: v1.1.1
 * Date:    21/03/2025
 */

package matthewyeend.simplequiz;

import java.util.Scanner;

/**
 *
 * @author matthewyeend
 */
public class SimpleQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Questions, options, and answers
        String[] questions = {
            "What is the capital of France?",
            "Which programming language is used for Android development?",
            "What is 5 + 7?",
            "Who developed Java?",
            "Which planet is known as the Red Planet?"
        };

        String[][] options = {
            {"1) Berlin", "2) Madrid", "3) Paris", "4) Rome"},
            {"1) Python", "2) Java", "3) Swift", "4) Kotlin"},
            {"1) 10", "2) 11", "3) 12", "4) 13"},
            {"1) Microsoft", "2) Google", "3) Sun Microsystems", "4) Apple"},
            {"1) Earth", "2) Mars", "3) Jupiter", "4) Venus"}
        };

        int[] answers = {3, 2, 3, 3, 2};  // Correct answer indexes (1-based)

        int score = 0;

        System.out.println("Welcome to the Quiz! Answer by entering the number of your choice.");

        // Loop through questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == answers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! The correct answer was: " + answers[i]);
            }
        }

        // Display final score
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.length);

        scanner.close();
    }
}

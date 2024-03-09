package CODSOFT;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\nWelcome to the Number Game.\nThe system will generate a random number between 1-100.");
        System.out.println("You have to guess that random number.\nYour score will be the number of attempts you took to guess the number.\n");

        System.out.print("Enter the number of rounds (between 1-5) you want to play the game: ");
        int rounds = scanner.nextInt();

        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            System.out.println("Round " + i + " begins ...\n");

            System.out.println("Please enter the difficulty level:\n1 --> Easy [There is no limit for the number of attempts]\n2 --> Hard [There is a limit for the number of attempts]");
            int limits = scanner.nextInt();

            switch (limits) {
                case 1: {
                    System.out.println("Opted for Easy Difficulty.\nHence, there is no limit to the number of attempts.\n");

                    int randomNumber = 1 + random.nextInt(100);
                    System.out.println("Random number has been generated...");

                    int count = 1;
                    while (true) {
                        System.out.print("Enter your guess number " + count + ": ");
                        int guess = scanner.nextInt();

                        if (guess > randomNumber) {
                            System.out.println("The number " + guess + " is HIGHER than the generated number. You have to guess again...");
                        } else if (guess < randomNumber) {
                            System.out.println("The number " + guess + " is LOWER than the generated number. You have to guess again...");
                        } else {
                            System.out.println("The number " + guess + " is EQUAL to the generated number.\nCongratulations! It took you "
                                    + count + " attempts.");
                            break;
                        }
                        count++;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Opted for Hard Difficulty.\nHence, there is a limit to the number of attempts.");
                    System.out.println("The limit is just 5.\nIf you have guessed the number in 5 or fewer attempts, you have won the game.\nElse you will lose the game.\n");

                    int randomNumber = 1 + random.nextInt(100);
                    System.out.println("Random number has been generated...");

                    int count = 1;
                    while (count <= 5) {
                        System.out.println("\nNumber of guesses remaining: " + (6 - count) + " ...\n");
                        System.out.print("Enter your guess number " + count + ": ");
                        int guess = scanner.nextInt();

                        if (guess > randomNumber) {
                            System.out.println("The number " + guess + " is HIGHER than the generated number. You have to guess again...");
                        } else if (guess < randomNumber) {
                            System.out.println("The number " + guess + " is LOWER than the generated number. You have to guess again...");
                        } else {
                            System.out.println("The number " + guess + " is EQUAL to the generated number.\nCongratulations! It took you "
                                    + count + " attempts.");
                            break;
                        }
                        count++;
                    }

                    if (count > 5) {
                        System.out.println("OOPS!!! You were not able to guess the number in 5 attempts.\nThe generated number was "
                                + randomNumber + "\nBETTER LUCK NEXT TIME\n");
                    }
                    break;
                }
                default: {
                    System.out.println("--- WRONG INPUT ---\n Sorry!!! But this round has been wasted.");
                    break;
                }
            }

            System.out.println("ROUND " + i + " is OVER.");
        }
        System.out.println("\nAll the rounds are over.\nThank you for playing the game.\nHope you enjoyed it.");
        scanner.close();
    }
}

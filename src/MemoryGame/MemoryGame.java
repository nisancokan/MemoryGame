package MemoryGame;
    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
     */


import java.io.File;
import java.util.Scanner;

    public class MemoryGame {

        private static Card[][] cards = new Card[4][4];

        public static void getFromFile() {
            Scanner scan = new Scanner(System.in);
            File file = new File ("kayit.bin");
            if (file.exists()) {
                System.out.print("You have a saved game. Would you like to continue?");
                String answer = scan.nextLine();
                if (answer.equals("yes")) {
                    cards = SaveGame.takeSave();
                    return;
                }

            }
            cards[0][0] = new Card('E');
            cards[0][1] = new Card('A');
            cards[0][2] = new Card('B');
            cards[0][3] = new Card('F');
            cards[1][0] = new Card('G');
            cards[1][1] = new Card('A');
            cards[1][2] = new Card('D');
            cards[1][3] = new Card('H');
            cards[2][0] = new Card('F');
            cards[2][1] = new Card('C');
            cards[2][2] = new Card('D');
            cards[2][3] = new Card('H');
            cards[3][0] = new Card('E');
            cards[3][1] = new Card('G');
            cards[3][2] = new Card('B');
            cards[3][3] = new Card('C');
        }
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            getFromFile();
            while (gameOver() == false) {
                gameBoard();
                System.out.print("Would you like to end the game? (yes / no):");
                String quit =scan.nextLine();
                if (quit.equals("yes")) {
                    System.out.println("Would you like to save the game? (yes / no ):");
                    String question = scan.nextLine();

                    if (question.equals("yes")) {
                        SaveGame.gameSave(cards);
                    }
                    else {
                        System.out.println("Game is not saved.");
                    }
                    System.out.println("Leaving the game...");
                    break;
                }
                Guess();

            }
        }

        public static void Guess() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("First guess, enter the values of i1 and j1 separated by a space:");
            int i1 = scanner.nextInt();
            int j1 = scanner.nextInt();
            cards[i1][j1].setGuess(true);
            gameBoard();
            System.out.println("Second guess, enter the values of i2 and j2 seperated by a space: ");
            int i2 = scanner.nextInt();
            int j2 = scanner.nextInt();

            if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
                System.out.println("Your guess is correct! Congratulations!");
                cards[i2][j2].setGuess(true);

            }
            else {
                System.out.println("Your guess is wrong. Try again.");
                cards[i1][j1].setGuess(false);
            }
        }

        public static boolean gameOver() {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (cards[i][j].getGuess() == false) {
                        return false;
                    }

                }
            }
            return true;
        }

        public static void gameBoard() {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (cards[i][j].getGuess()) {
                        System.out.print(" |" + cards[i][j].getValue() + "| ");
                    } else {
                        System.out.print(" | | ");
                    }
                }
                System.out.println("");
            }
        }
    }


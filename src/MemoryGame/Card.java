package MemoryGame;

public class Card {
    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */


    /**
     *
     * @author musta
     */

        private char value;
        private boolean guess = false;
        public Card (char value) {
            this.value = value;
        }
        public void setValue(char value){
            this.value=value;

        }
        public char getValue() {
            return value;
        }
        public void setGuess(boolean guess){
            this.guess = guess;
        }
        public boolean getGuess() {
            return guess;
        }
    }


package com.andreas.projektarbete;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    static User user = new User("", 500,0);
    static Dealer dealer = new Dealer("Linda", 500, 0);



    // <-- Start Menu Method -->
    public static void runStartMenu() {

        System.out.print("""
               
               (♥)------------------------------(♤)
                 <> BLACK JACK - The Card Game <>
               (♢)------------------------------(♧)
                
                """);

        String dealerName = dealer.getName();
        System.out.println("-Hi and welcome. My name is " + dealerName + " and I am the Dealer.\n" +
                "What is your name?");

        String userName = user.setName(scan.next());
        System.out.println("-Alright. Nice too meet you " + userName + "! Whenever you feel ready:\n");
        System.out.println("""
                ♥  Press 1 + RETURN to BET  ♤
                ♢  Press 0 + RETURN to QUIT  ♧""");


        boolean playGame = true;

        do {

            switch (scan.next()) {
                case "0" -> {
                    System.out.println("-Ok, maybe another time then!");
                    playGame = false;
                }
                case "1" -> User.betting();
                case "2" -> runGameEngine();
                default -> System.out.println("-Enter a valid number: 2 + RETURN to PLAY, 0 + RETURN to QUIT!");
            }
        } while (playGame);

    }

    // <--Game Engine Method-->
    public static void runGameEngine() {

        // <-- Starts by clearing cards -->
        dealer.usersCards.clear();
        dealer.dealersCards.clear();

        Deck deckTemplate = new Deck();
        List<Card> deckOfCards = deckTemplate.generateDeck();

        // <-- Shuffle cards -->
        //Shuffle the list by Collections.shuffle, then returning an object representation.
        Collections.shuffle(deckOfCards);
        System.out.println("Great. Now the dealer " + Game.dealer.getName() + " will shuffle the deck of cards.\n");
        //System.out.println(Game.user.getMoney()-Game.user.getUsersBet());
        System.out.println("♥ Press 1 + RETURN to start the GAME ♤");

        boolean isPlaying = true;
        // <-- Game engine loop -->
        do {
            switch (scan.next()) {
                case "0": {
                    isPlaying = false;
                    System.exit(0);
                }
                case "1": {
                    dealer.calcHit(deckOfCards, deckOfCards);
                    System.out.println("""
                            Do you want another card? 
                            ♥ Press 1 + RETURN to HIT   ♤
                            ♢ Press 2 + RETURN to STAY ♧""");
                }
                break;
                case "2":
                    dealer.calcStay(deckOfCards);
                    break;
                default:
                    System.out.println("-Enter a valid number: 1 + RETURN to PLAY, 0 + RETURN to Quit!");
                    break;
            }
        } while (isPlaying);
    }

    // <-- End Game Engine Method -->

    public static void endGameEngine() {
        System.out.println("""
                -Would you like to PLAY again or EXIT the game?
                ♥ Press 1 + RETURN -> new BET ♤
                ♢ Press 0 + RETURN -> EXIT GAME  ♧ """);

        boolean playGame = true;

        do {

            switch (scan.next()) {

                case "0" -> {
                    System.out.println("-Thank You " + Game.user.getName() + " for PLAYING!");
                    playGame = false;
                    System.exit(0);

                }
                case "1" -> User.betting();
                default -> System.out.println("Enter a valid number: 1 + RETURN to PLAY, 0 + RETURN to EXIT GAME!");
            }
        }  while (playGame) ;
    }
}




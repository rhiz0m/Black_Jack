package com.andreas.projektarbete;

import java.util.Scanner;

public class User extends Participants {

    private int usersBet;
    // <-- Constructor -->
    public User(String name, int money, int wins) {
        super(name, money, wins);
    }

    public int getUsersBet() {
        return usersBet;
    }

    public void setUsersBet(int usersBet) {
        this.usersBet = usersBet;
    }
    public static void betting() {
        System.out.println("You have: " + Game.user.getMoney() + " $ ");
        System.out.println("-Type in a number between 2 and 500 that you are willing to bet!");
        Scanner scan = new Scanner(System.in);
        int usersBet = scan.nextInt();

        Game.user.setUsersBet(usersBet);

        int initialCurrency = Game.user.getMoney();
        int newCurrency = initialCurrency - usersBet;

        boolean isAsking = true;
        do {

            if ((usersBet >= 2) && (usersBet <= 500)) {
                System.out.println("-You bet " + usersBet + " $ and have " + newCurrency +
                        " $ left!");
                Game.runGameEngine();

            } else if (usersBet == 0) {
                System.out.println("You are about to EXIT the game!\nPress 0 + RETURN once more end the GAME!");
                isAsking = false;
            } else {
                System.out.println("Enter a valid number between 2 and 500");
            }

        } while(isAsking);
    }
};

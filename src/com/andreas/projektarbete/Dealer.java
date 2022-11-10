package com.andreas.projektarbete;

import java.util.List;
import java.util.ArrayList;


public class Dealer extends Participants {
    List<Card> usersCards = new ArrayList<>();
    List<Card> dealersCards = new ArrayList<>();

    public Dealer(String name, int money, int wins) {
        super(name, money, wins);
    }

    public int addCardToUser(List<Card> cardInput) {

        usersCards.add(cardInput.get(0));
        cardInput.remove(0);
        // <-- Loop that counts the sum of users cards -->

        int userSum = 0;
        for (Card usersCard : usersCards) {
            userSum += usersCard.cardValueToInt(usersCards);
        }
        //System.out.println(usersCards);

        System.out.println(usersCards.get(usersCards.size() - 1).getCardValue() +
                usersCards.get(usersCards.size() - 1).getCardSymbol());
        System.out.println("♢-- The total SUM for " + Game.user.getName() + " is: " + userSum + " --♢\n");

        return userSum;
    }

    public int addCardToDealer(List<Card> cardInput) {
        dealersCards.add(cardInput.get(0));
        cardInput.remove(0);

        // <-- Loop that counts the sum of dealers cards -->

        int dealerSum = 0;
        for (Card dealerCard : dealersCards) {
            dealerSum += dealerCard.cardValueToInt(dealersCards);
        }
        //System.out.println(dealersCards);

        System.out.println(dealersCards.get(usersCards.size() - 1).getCardValue() +
                dealersCards.get(usersCards.size() - 1).getCardSymbol());
        System.out.println("♢-- The total SUM for " + Game.dealer.getName() +
                " is " + dealerSum + " --♢\n");

        return dealerSum;
    }

    public void calcHit(List<Card> addUserSum, List<Card> addDealerSum) {

        int userSum = addCardToUser(addUserSum);
        int dealerSum = addCardToDealer(addDealerSum);

        int usersBet = Game.user.getUsersBet();
        int userMoney = Game.user.getMoney();
        int dealerMoney = Game.dealer.getMoney();
        int dealerWinMoney = dealerMoney + usersBet;
        int dealerLooseMoney = dealerMoney -usersBet;
        int userWinMoney = userMoney + usersBet;
        int userLosesMoney = userMoney - usersBet;

        // <-- Conditionals to check other cases -->

        if (userSum > 21) {
            Game.dealer.setWins(Game.dealer.getWins() + 1);
            System.out.println("---♤ | You lost! | ♤---\n");
            System.out.println("The Dealer receives your: " + usersBet + " $");
            System.out.println("You have : " + Game.user.setMoney(userLosesMoney) + " $ left");
            System.out.println("Total Wins is: " + Game.dealer.getWins()+ "\n");
            Game.endGameEngine();

        } else if (userSum == 21) {
            Game.user.setWins(Game.user.getWins() + 1);
            System.out.println("---♥ | " + Game.user.getName() + " got BLACK JACK! | ♥---");
            System.out.println("Your bet: " + usersBet);
            System.out.println("Your total is now: " + Game.user.setMoney(userWinMoney) + " $");
            System.out.println("Total Wins is: " + Game.user.getWins()+ "\n");
            Game.endGameEngine();

        } else if (dealerSum > 21) {
            Game.user.setWins(Game.user.getWins() + 1);
            System.out.println("---♥ | " + Game.user.getName() + " WON! | ♥---\nThe Dealer exceeded the value 21");
            System.out.println("You bet: " + usersBet);
            System.out.println("Your total is now: " + Game.user.setMoney(userWinMoney) + " $");
            System.out.println("Total Wins is: " + Game.user.getWins()+ "\n");
            Game.endGameEngine();

        } else if (dealerSum == 21) {
            Game.dealer.setWins(Game.dealer.getWins() + 1);
            System.out.println("The Dealer " + Game.dealer.getName() + " got BLACK JACK!");
            System.out.println("You have : " + Game.user.setMoney(userLosesMoney) + " $ left");
            System.out.println("Total Wins is: " + Game.dealer.getWins()+ "\n");
            Game.endGameEngine();
        }
    }

    public void calcStay(List<Card> addDealerSum) {

        int userSum = addCardToUser(usersCards);
        int dealerSum = addCardToDealer(addDealerSum);

        int usersBet = Game.user.getUsersBet();
        int userMoney = Game.user.getMoney();
        int dealerMoney = Game.dealer.getMoney();
        int userWinMoney = userMoney + (dealerMoney - usersBet);
        int userLosesMoney = userMoney - usersBet;

        int userSumClosest = 21 - userSum;
        int dealerSumClosest = 21 - dealerSum;

        if (userSumClosest < dealerSumClosest || dealerSum > 21) {
            Game.user.setWins(Game.user.getWins() + 1);
            System.out.println("---♥ | " + Game.user.getName() + " WON! | ♥---\nThe Dealer exceeded the value 21");
            System.out.println("You bet: " + usersBet);
            System.out.println("Your total is now: " + Game.user.setMoney(userWinMoney) + " $");
            System.out.println("Total Wins is: " + Game.user.getWins()+ "\n");
            Game.endGameEngine();
        } else if (userSumClosest > dealerSumClosest || userSum > 21) {
            System.out.println("---♤ | You lost! | ♤---\n");
            System.out.println("The Dealer receives your: " + usersBet + " $");
            System.out.println("You have total : " + Game.user.setMoney(userLosesMoney) + " $ left");
            System.out.println("Total Wins is: " + Game.dealer.getWins() + "\n");
            Game.endGameEngine();
        }
    }

    public void checkMoneyBounds() {
        if(Game.user.getMoney() <= 0) {
            System.out.println("you have no money left");
        }
    }
}




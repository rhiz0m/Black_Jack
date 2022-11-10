package com.andreas.projektarbete;

import java.util.List;

public class Card {

    private String cardSymbol;
    private String cardValue;


    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return "{" +
                " cardValue = '" + cardValue + '\'' +
                ", cardSymbol = '" + cardSymbol + '\'' +
                '}' + "\n";
    }
    public int cardValueToInt(List<Card> cardInput) {

        //Converting string to Int
            int stringNum = 0;

        switch (this.getCardValue()) {
            case "Ace" -> stringNum = 11;
            case "2" -> stringNum = 2;
            case "3" -> stringNum = 3;
            case "4" -> stringNum = 4;
            case "5" -> stringNum = 5;
            case "6" -> stringNum = 6;
            case "7" -> stringNum = 7;
            case "8" -> stringNum = 8;
            case "9" -> stringNum = 9;
            case "10", "Jack", "Queen", "King" -> stringNum = 10;
            default -> System.out.println("Error");
        }


        return stringNum;
    }

}

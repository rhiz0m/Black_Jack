package com.andreas.projektarbete;



//SUPERCLASS: Participants

public class Participants {
    private String name;
    private int money;
    private int wins;



    //CONSTRUCTOR
    public Participants(String name, int money, int wins) {
        this.name = name;
        this.money = money;
        this.wins = wins;

    }

    //GETTERS for the superclass

    public String getName() {
        return this.name;
    };

    public String setName(String name) {
        return this.name = name;
    };

    public int getMoney() {
        return money;
    }

    public int setMoney(int money) {
        this.money = money;
        return money;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

};


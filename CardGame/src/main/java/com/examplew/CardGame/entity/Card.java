package com.examplew.CardGame.entity;

public class Card {
    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;

    public final static int ACE = 14;
    public final static int KING = 13;
    public final static int JACK = 12;
    public final static int QUEEN = 11;

    private final int suit;
    private final int value;


    public Card(int value, int suit) {
        this.suit = suit;
        this.value = value;
    }


    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}

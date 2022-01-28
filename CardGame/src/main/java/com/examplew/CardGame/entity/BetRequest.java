package com.examplew.CardGame.entity;

import org.springframework.stereotype.Component;

@Component
public class BetRequest {
    private int bet;
    private int balance;
    private String guess;
    private Card card;

    public BetRequest() {
    }

    public int getBet() {
        return bet;
    }

    public BetRequest setBet(int bet) {
        this.bet = bet;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public BetRequest setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public String getGuess() {
        return guess;
    }

    public BetRequest setGuess(String guess) {
        this.guess = guess;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public BetRequest setCard(Card card) {
        this.card = card;
        return this;
    }
}

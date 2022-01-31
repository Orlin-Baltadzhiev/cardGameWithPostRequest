package com.examplew.CardGame.service;


import com.examplew.CardGame.entity.BetRequest;
import com.examplew.CardGame.entity.Card;
import org.springframework.http.ResponseEntity;

public interface DataService {


    int getBalance();

    void BalanceMinusBet(int amount);

    Card shuffleTheDeck();

    BetRequest playTheGame(int bet, String guess);

    Card cardFromTheDeck();

    void increaseTheBalance(int balance);

    int getCardLeft();

    ResponseEntity<Card> firstCardFromTheDeck();

}

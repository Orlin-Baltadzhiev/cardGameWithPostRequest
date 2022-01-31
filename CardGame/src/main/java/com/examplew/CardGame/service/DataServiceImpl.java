package com.examplew.CardGame.service;

import com.examplew.CardGame.entity.BetRequest;
import com.examplew.CardGame.entity.Card;
import com.examplew.CardGame.entity.Deck;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    public int balance;
    private Card currentCard;
    public Deck deck;
    private BetRequest player1 = new BetRequest();

    @Override
    public int getBalance() {
        return this.player1.getBalance();
    }

    @Override
    public void increaseTheBalance(int newBalance) {
        int currentBalance = player1.getBalance();
        player1.setBalance(newBalance + currentBalance);
    }

    @Override
    public int getCardLeft() {
        return deck.cardLeft();
    }

    @Override
    public ResponseEntity<Card> firstCardFromTheDeck() {
        currentCard = shuffleTheDeck();
        return ResponseEntity.ok(currentCard);
    }


    @Override
    public void BalanceMinusBet(int amount) {
        this.balance -= amount;
    }

    @Override
    public Card shuffleTheDeck() {         // new deck Add here
        this.deck = new Deck();
        deck.shuffle();
        Card firstCard = deck.dealCard();
        System.out.println("The cards have shuffled! Cards Left:" + deck.cardLeft());
        return firstCard;
    }

    @Override
    public BetRequest playTheGame(int currentBet, String guess) {
        if (deck.cardLeft() == 0) {
            deck.shuffle();
        }
        Card nextCard = cardFromTheDeck();
        player1.setBet(currentBet);
        player1.setCard(nextCard);        //currentCard = deck.dealCard();
        //TODO: check the balance

        if (nextCard.getValue() == currentCard.getValue()) {
            currentCard = nextCard;
            player1.setGuess("equal");
            return player1;
        }


        if (nextCard.getValue() > currentCard.getValue()) {
            if (guess.equals("H")) {
                currentCard = nextCard;
                player1.setBalance(player1.getBalance() + currentBet * 2);
                return player1.setGuess("win");
            } else {
                currentCard = nextCard;
                player1.setBalance(player1.getBalance() - currentBet);
                return player1.setGuess("lose");
            }
        } else if (nextCard.getValue() < currentCard.getValue()) {
            if (guess.equals("L")) {
                currentCard = nextCard;
                player1.setBalance(player1.getBalance() + currentBet * 2);
                return player1.setGuess("win");
            } else {
                currentCard = nextCard;
                player1.setBalance(player1.getBalance() - currentBet);
                return player1.setGuess("lose");
            }
        }

        currentCard = nextCard;
        return player1;
    }

    @Override
    public Card cardFromTheDeck() {
        return deck.dealCard();
    }
}




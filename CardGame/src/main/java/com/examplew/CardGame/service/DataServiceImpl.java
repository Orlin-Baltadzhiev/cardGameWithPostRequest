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
        int currentBalance =player1.getBalance();
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
        return firstCard ;
    }

    @Override
    public BetRequest playTheGame(int currentBet, String guess) {
        if(deck.cardLeft() ==0 ){
            deck.shuffle();
        }
        Card nextCard= cardFromTheDeck();
        player1.setBet(currentBet);
        player1.setCard(nextCard);        //currentCard = deck.dealCard();
        //TODO: check the balance

        if(nextCard.getValue() == currentCard.getValue()){
            currentCard = nextCard;
            player1.setGuess("equal");
            return player1;
        }


            if (nextCard.getValue() > currentCard.getValue()) {
              if (guess.equals("H")) {
                  currentCard = nextCard;
                  player1.setBalance(player1.getBalance() + currentBet*2);
                  return player1.setGuess("win");
              } else {
                  currentCard = nextCard;
                  player1.setBalance(player1.getBalance() - currentBet);
                  return player1.setGuess("lose");
              }
          } else if (nextCard.getValue() < currentCard.getValue()) {
              if (guess.equals("L")) {
                  currentCard = nextCard;
                  player1.setBalance(player1.getBalance() + currentBet*2);
                 return  player1.setGuess("win");
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

//    @Override
//    public ResponseEntity<Card> firstCardFromTheDeck() {
//        Card firstCard = shuffleTheDeck();
//        return ResponseEntity.ok(firstCard);
//    }

}


//    private static int play(int balance) {
//       Deck deck = new Deck();
//       Card currentCard;
//       Card nextCard;
//       String answer;
//       deck.shuffle();
//
//       currentCard = deck.dealCard();
//
//       System.out.println("The first card is the " + currentCard);
//       System.out.println("Make a bet");
//       int currentBet = checkTheBalanceWithCurrentBet(balance);
//
//       System.out.println("Your bet is " + currentBet);
//
//
//       while (true) {
//           System.out.println("What will be the next card 'L' or 'H' or shuffle, bet , start");
//           do {
//               answer = scanner.next();
//               if (checkTheCommand(answer)) {
//                   System.out.println("Please enter the valid command 'L' or 'H' or 'shuffle' or 'bet' or 'start'?");
//               }
//           } while (checkTheCommand(answer));
//
//           if (answer.equals("shuffle")) {
//               shuffleTheDeck(currentCard);
//               continue;
//           }
//
//           nextCard = deck.dealCard();
//           System.out.println("Next card is " + nextCard);
//
//           if (nextCard.getValue() == currentCard.getValue()) {
//               System.out.println("The cards are the same");
//               // we do nothing
//           } else if (nextCard.getValue() > currentCard.getValue()) {
//               if (answer.equals("H")) {
//                   System.out.println("Correct answer");
//                   balance += currentBet * 2;
//               } else {
//                   System.out.println("Your answer is not  correct");
//                   balance -= currentBet;
//               }
//           } else if (nextCard.getValue() < currentCard.getValue()) {
//               if (answer.equals("L")) {
//                   System.out.println("Correct answer");
//                   balance += currentBet * 2;
//               } else {
//                   System.out.println("Your answer is not correct");
//                   balance -= currentBet;
//               }
//           }
//           System.out.println("Card in the deck: " + deck.cardLeft());
//           System.out.print("Your balance is: " + balance + "$$ Make a bet:");
//
//
//           currentBet = checkTheBalanceWithCurrentBet(balance);
//           currentCard = nextCard;
//           //TODO when the cards are 0 -> shuffle
//       }
//   }
//
//   private static int checkTheBalanceWithCurrentBet(int balance) {
//       int currentBet;
//       do {
//           currentBet = scanner.nextInt();
//           if (balance < currentBet) {
//               System.out.println("There is not enough money in the balance");
//               System.out.printf("Please enter a valid sum, your balance is %d $$%n", balance);
//           }
//       } while (balance < currentBet);
//
//       return currentBet;
//   }
//
//
//   private static void shuffleTheDeck(Card currentCard) {
//       Deck deck = new Deck();
//       deck.shuffle();
//       System.out.println("The cards have shuffled");
//       Card firstCard = deck.dealCard();
//       firstCard(currentCard);
//       System.out.println("The cards in the deck are: " + deck.cardLeft());
//   }
//
//   private static int firstCard(Card currentCard) {
//       System.out.println("The first card is the " + currentCard);
//       System.out.println("Make a bet");
//       int currentBet = scanner.nextInt();
//       //TODO to validate  currentBet only integers;
//       return currentBet;
//   }
//
//
//   private static boolean checkTheCommand(String answer) {
//       return !answer.equals("H") && !answer.equals("L") &&
//               !answer.equals("shuffle") && !answer.equals("bet") &&
//               !answer.equals("start");
//   }



package com.examplew.CardGame.web;


import com.examplew.CardGame.entity.BetRequest;
import com.examplew.CardGame.entity.Card;
import com.examplew.CardGame.service.DataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CardController {

    private final DataService dataService;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final BetRequest player1;
    public CardController(DataService dataclassService, BetRequest betRequest, BetRequest player1) {
        this.dataService = dataclassService;
        this.player1 = player1;
    }

    //increase the balance on the player and returns the first card
    @PostMapping("/start")
    public ResponseEntity<Card> balance(@RequestBody BetRequest betRequest) {
        dataService.increaseTheBalance(betRequest.getBalance());
//         return dataService.saveTheCurrentCard(dataService.firstCardFromTheDeck());
        return dataService.firstCardFromTheDeck();
    }

    //shuffle the deck and returns the first card from the deck
    @GetMapping("/shuffle")
    public ResponseEntity<Card> shuffleTheDeck() {
        return dataService.firstCardFromTheDeck();
    }


    @PostMapping(value = "/betRequest", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<BetRequest> betRequest(@RequestBody BetRequest betRequest) {
        //Приема залога и връща и резултат от теглената карта печеливщ или не;
        betRequest  = dataService.playTheGame(betRequest.getBet(), betRequest.getGuess());
        return ResponseEntity.ok(betRequest);

    }



    @GetMapping("/seeTheBalance")
    public String seeTheBalance() {
        return "Your current balance: " +dataService.getBalance() + " Card Left " + dataService.getCardLeft();
    }
//
//    @GetMapping("/play")
//    public String startTheGame() {
//        Card firstCard = deck.dealCard();
//        return this.gson.toJson(firstCard);
//    }
//
//    @GetMapping()
//    public StringBuilder welcome() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("******************** Welcome in High Low Card Game ********************");
//        sb.append("\n");
//        sb.append("Enter 'start' to starting the game.");
//
//        System.out.println("Enter 'start' to starting the game.");
//        return sb;
//    }


}

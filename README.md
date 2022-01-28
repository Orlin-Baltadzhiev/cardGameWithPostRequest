# *********** Welcome in High Low Card Game ***********

### 1) Short info about the game.
- This is a very basic cards game API.
- With this program you can easy to play your favorite game.
- Your balance in the game depends on correct answers.
- You have to predict whether the next card will be lower or higher.
- Before you start follow the instructions.


### 2) Prerequisites
- Java 8 or higher
- Maven
- Git

### 3) Rules in the game

The rules in the game are very easy. First you have to provide a ***money*** to start a game and then you will see the first card.With command **start** you start the game and increase your balance. The other command is **BET**. With this command you will see the first card. After this you have to to predict whether the next card will be **lower or higher**.When the deck of cards is finished, the deck will renew automatically. Anothre command in the game is **shuffle**. With this command **you shuffle and return the new deck.**With **balance** command, you can easy to check your **current balance**.

### 4) Commands

- **Example for requests**

- http://localhost:8080/start POST
{
    "balance": 1200   
}

- http://localhost:8080/bet POST
{
   "bet":250,
   "guess":"Low"
}

- http://localhost:8080/shuffle GET

- http://localhost:8080/seeTheBalance GET





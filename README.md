# ******************** Welcome in High Low Card Game ********************


This is a very basic cards game API.

### 1) Prerequisites
- Java 8
- Maven
- Git




1 .Start the game http://localhost:8080/start   request:POST
{
    "balance": 1200   
}

2. If you want to make a bet 
http://localhost:8080/betRequest   request:POST
{
   "bet":250,
   "guess":"L"
}
L - Low
H - High

3. If you want to shuffle and get the first card
 http://localhost:8080/shuffle  request:GET

4.http://localhost:8080/seeTheBalance  request:GET
If you want to see the balance 




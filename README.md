# High or low Card Game
1 .Start the game http://localhost:8080/start   POST
{
    "balance": 1200   
}

2. If you want to make a bet 
http://localhost:8080/betRequest   POST
{
   "bet":250,
   "guess":"L"
}
L - Low
H - High

3. If you want to shuffle and get the first card
 http://localhost:8080/shuffle GET

4.http://localhost:8080/seeTheBalance  GET
If you want to see the balance 




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iryna Naminat
 */



//This class stores information for the game players.
public class Player {
    private String name;
    private int balance;
    private int betAmount;
    private int guess;
    private int secondGuess;
    public int INITIAL_BALANCE=500;

//The constructor will initialize the name field and initialize balance to the INITIAL_BALANCE.
    public Player(String name) {
        this.name = name;
        balance = INITIAL_BALANCE;
    }
//Implement the getters 
    public String getName() {
        return name;
    }

    public int  getBalance() {
        return balance;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public int getGuess() {
        return guess;
    }

    public int getSecondGuess() {
        return secondGuess;
    }

//Implement the setters.    
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void setSecondGuess(int secondGuess) {
        this.secondGuess = secondGuess;
    }
      
}



import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iryna Naminat
 */

//This class handles all of the game logistics.

public class DiceGame {
    private Player [] players;
    private int numPlayers=0;
    private int pot=0;
    private boolean gameOver=false;
    private String mode;
    
//Constructor, which call setUpGame method.
    public DiceGame() {
        setUpGame();
    }
    
//Implement the getters
    public Player[] getPlayers() {
        return players;
    }

    public int getNumPlayers() {
        return numPlayers;
    }
   
   private static Scanner scanner = new Scanner(System.in);
      
    public void setUpGame() {
    
    //Ask player to enter the mode of the game to play on. Assign user’s input to the field.    
    System.out.println("Choose mode the game: easy or hard");        
    System.out.println("Type the name of mode, using lowercase letter:");        
      mode = scanner.next();  
    
    //Ask how many people are going to play. Assign the input to the numPlayers field
        
    System.out.println("How many people are playing?");
     numPlayers = scanner.nextInt();

   //Create an array of Player objects and assign that to the players field.
     players = new Player[getNumPlayers()];
     
       
/*Ask for each player’s name. Create a new Player object with that name and 
add that Player object to the array of players*/
        for (int i = 0; i < players.length; ++i) {
            System.out.println("Print player's name:");
            String playerName = scanner.next();
            players[i] = new Player(playerName);
        }
// Display the rules for game depending from players choise.
        if (mode.equals("easy")) {
            displayRules();
        } 
        if (mode.equals("hard")) {
            displayHardRules();
        }
        
    }// end setUpGame method.
    
//This method displays the Game Rule for easy mode.   
   public void displayRules(){
   System.out.println("\n RULES!"
           + "\n Each player places a bet and chooses a number between 2 and 12."
           + "\n The total of all the bets forms a \"Pot\"."
           + "\n Then two dices are rolled."
           + "\n If one of the players bet on the result correctly, she or he wins the entire pot."
           + "\n If more than one player bet on tat number, the one who bet the most wins the entire pot."
           + "\n It there is a tie, they split the pot."
           + "\n If nobody bet on that number, the money remains in the pot for the next round."
           + "\n The game is over if one of the players run out of money. ");
            }
  
//This method displays the Game Rule for hard mode.  
   public void displayHardRules(){
   System.out.println("\n RULES!"
           + "\n Each player places a bet and chooses a numbers on two dises separately between 1 and 6."
           + "\n The total of all the bets forms a \"Pot\"."
           + "\n Then two dices are rolled."
           + "\n If one of the players guesses both numbers, she or he wins the entire pot."
           + "\n If more than one player guesses both numbers, the one who bet the most wins the entire pot."
           + "\n It there is a tie, they split the pot."
           + "\n If nobody bet on that numbers, the money remains in the pot for the next round."
           + "\n The game is over if one of the players run out of money. ");
            }   
   
   
    public void playGame() {
    /*Loop through each player in the array, call the playTurn method with each player. 
    Accumulate each player’s bet amount to the pot*/
        for (int i = 0; i <players.length; ++i) {
            playTurn(players[i]);
            this.pot += players[i].getBetAmount();
        }
    //Display the balance in the pot.
        System.out.println("Balance in the pot: $" + this.pot);

    /*randomly generate two integers between 1 and 6 to simulate the outcome of rolling two dices. 
    Add these two integers together and assign the value to a local variable named outcome.*/
      
    //----------------------------6------------------------
     Random random = new Random();
        int outcome, firstDice, secondDice = 0;
        if (mode.equals("easy")) {

            outcome = (int) (Math.random() * 12) + 1;
            System.out.println("Summ numbers on the dices is: " + outcome);
            checkWinner(outcome);
        }

        if (mode.equals("hard")) {

            firstDice = (int) (Math.random() * 6) + 1;
            secondDice = (int) (Math.random() * 6) + 1;
            System.out.println("Number on one dice is :" + firstDice);
            System.out.println("Number on one dice is :" + secondDice);
            checkWinner(firstDice, secondDice);

        }
        
    /*Loop through each player to check if any player’s balance is 0. 
    Set gameOver to true if any player’s balance is 0.*/
        for (int i = 0; i < players.length; ++i) {
            if (players[i].getBalance() == 0) {
                gameOver = true;
               
            }
        }
    }

    public void playTurn(Player player) {
        //Tell the player his or her balance, and ask him or her to enter the amount to bet. 
        System.out.println("Player " + player.getName() + " Your balance is: " + player.getBalance());


        /*If the amount exceeds the balance, output “Bet balance exceeds available funds” and 
    ask the player to enter the amount of the bet.
    Repeat until the player’s bet is less or equal to the bet balance.*/
        int betAmount = 0;
        while (true) {

            System.out.println("Enter the amount to bet: ");
            betAmount = scanner.nextInt();
            if (betAmount <= player.getBalance()) {
                player.setBetAmount(betAmount);
                player.setBalance(player.getBalance() - betAmount);

                break;
            } else {
                System.out.println("Bet balance exceeds available funds.");
            }
        }
        /*Assign the input to the player’s betAmount field. 
    Update the player’s balance by subtracting the betAmount. */

        //EASY MODE. Choose dice
        if (mode.equals("easy")) {
            while (true) {
                /*Ask the player to enter his or her guess. Assign the input to his or her guess field. 
            Your program should not accept the input if it is not in the range of 2 and 12. */
                System.out.println("Enter your guess between 2 and 12: ");
                int guess = scanner.nextInt();
                if (guess >= 2 && guess <= 12) {
                    player.setGuess(guess);
                    break;
                } else {
                    System.out.println("Entered number not in the range from 2 to 12: ");
                }
            }
        } //enf if for easy mode 

        //HARD MODE. Choose dises
        if (mode.equals("hard")) {
           
            while (true) {
                System.out.println("Enter your guess for 1 dice between 1 and 6: ");
            
                int guessOne = scanner.nextInt();
                if (1 <= guessOne && guessOne <= 6) {
                    player.setGuess(guessOne);
                
                }
                System.out.println("Enter your guess for 2 dice between 1 and 6: ");
                int guessTwo = scanner.nextInt();
                
                if (1 <= guessTwo && guessTwo <= 6) {
                    player.setSecondGuess(guessTwo);
                    break; 
                } 
               
            else {
                    System.out.println("One of the number not in the range from 1 to 6: ");
                    System.out.println("Make your choise again");
                }
            }
        }//enf if for hard mode 
    }// end playTurn method
    
    
/*EASY MODE. This method find out if any player correctly guessed the outcome and update each player’s balance 
and the balance of the pot accordingly.          
This method should also display how much each player won or lost in this round.*/    
    public void checkWinner(int outcome) {

        //keep track of # players correct
        int playerCorrect = 0;

         
        for (int i = 0; i < players.length; i++) {
            if (players[i].getGuess() == outcome) {
                playerCorrect++;
            }
        }

        if (playerCorrect == 0) {
            System.out.println("Nobody won");  }

        
        if (playerCorrect == 1) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].getGuess() == outcome) {
                    players[i].setBalance(players[i].getBalance() + this.pot);
                    this.pot = 0;
                    break;
                }
            }// end for 
        }//end if (playerCorrect==1)

        if (playerCorrect > 1) {
            int hightBet = 0;
            int highestBetAmount = 0;
            
            // get the highest Bet Amount
            for (int i = 0; i < players.length; i++) {
                if (players[i].getBetAmount() > highestBetAmount) {
                    highestBetAmount = players[i].getBetAmount();
                } //end if
            } //end for

             // count how many players have the highest Bet Amount  
            for (int i = 0; i < players.length; i++) {
                if (players[i].getBetAmount() == highestBetAmount) {
                    hightBet++;
                }// end if
            }// end for

            if (highestBetAmount >= 1) {
                for (int i = 0; i < players.length; i++) {
                    if (players[i].getBetAmount() == highestBetAmount) {
                        players[i].setBalance(players[i].getBalance() + (this.pot / highestBetAmount));
                    }
                }// end for
                this.pot = 0;
            } //end if
        }// end if (playerrCorrect>1)
        
        //Printing result after each round for each player
        for (int i = 0; i < players.length; i++) {
            if (players[i].getGuess() == outcome) {
                System.out.println(players[i].getName() + " won. Your balance is $" + players[i].getBalance());
            } else {
                System.out.println(players[i].getName() + " your lost is $" + players[i].getBetAmount());
            }
        }
    } //end of checkWinner method easy mode

  
    
   
  /*  HARD MODE. This method find out if any player correctly guessed the outcome and update each player’s balance 
and the balance of the pot accordingly.          
This method should also display how much each player won or lost in this round.*/   
   
    public void checkWinner(int firstDice, int secondDice){
    
        //keep track of # players correct
        int playerCorrect = 0;
         
        for (int i = 0; i < players.length; i++) {
            if (players[i].getGuess() == firstDice && players[i].getSecondGuess()==secondDice) {
                playerCorrect++;
            }
        }
       
         if (playerCorrect == 0) {
            System.out.println("Nobody won");
            mode.equals("easy");}
         
          if (playerCorrect == 1) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].getGuess() == firstDice && players[i].getSecondGuess()==secondDice) {
                    players[i].setBalance(players[i].getBalance() + this.pot);
                    this.pot = 0;
                    break;
                }
            }// end for 
        }//end if (playerCorrect==1)
         
      if (playerCorrect > 1) {
            int hightBet = 0;
            int highestBetAmount = 0;
            
            // get the highest Bet Amount
            for (int i = 0; i < players.length; i++) {
                if (players[i].getBetAmount() > highestBetAmount) {
                    highestBetAmount = players[i].getBetAmount();
                } //end if
            } //end for

             // count how many players have the highest Bet Amount  
            for (int i = 0; i < players.length; i++) {
                if (players[i].getBetAmount() == highestBetAmount) {
                    hightBet++;
                }// end if
            }// end for

            if (highestBetAmount >= 1) {
                for (int i = 0; i < players.length; i++) {
                    if (players[i].getBetAmount() == highestBetAmount) {
                        players[i].setBalance(players[i].getBalance() + (this.pot / highestBetAmount));
                    }
                }// end for
                this.pot = 0;
            } //end if
        }// end if (playerrCorrect>1)  
       
       //Printing result after each round for each player
        for (int i = 0; i < players.length; i++) {
            if (players[i].getGuess() == firstDice && players[i].getSecondGuess()==secondDice) {
                System.out.println(players[i].getName() + " won. Your balance is $" + players[i].getBalance());
            } else {
                System.out.println(players[i].getName() + " your lost is $" + players[i].getBetAmount());
            }
        }
      
   }// end of checkWinner method hard mode
   
   
   
   
   
   
   
   
   
    public boolean isGameOver() {
        return gameOver;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2lottery;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Iryna Naminat
 */
public class Lab2Lottery {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        
                // TODO code application logic here
displayRules ();   
             
 int[] winningNumbers = generateWinningNumbers();
 int[] playerPicks = getPlayerPicks();

 //statements to print out each element of winningNumbers and playerPicks.

 System.out.print ("Winning tickets is: ");
 for (int m = 0; m < winningNumbers.length; m++){ //for loop to print the array  
 System.out.print( winningNumbers[m]+ " ");   }
 
 System.out.print ("\n"+"Player's pick is: ");
 for (int m = 0; m < playerPicks.length; m++){ //for loop to print the array  
 System.out.print( playerPicks[m]+ " ");   }
   
int matching = matchNumbers(winningNumbers, playerPicks);
System.out.println("Number of matching digits: " + matching);

     //calculatePrize(matching);    
     calculatePrize(winningNumbers, playerPicks);
    }
   
/**
 * This method prints out rules of the Lottery
 */

public static void displayRules (){
        System.out.print ("Welcome to the Fantasy Five Lottery.\n" +
  "Each player picks 5 numbers between 0-35.\n" +
  "Drawings are held Monday through Saturday at 5:00 pm.\n" +
  "Best of luck in your game!\n");
}

/**
 * Method creates 5 random numbers for drop off Lottery
 * @return the value of winning numbers
 */
public static int[] generateWinningNumbers(){
        
        //Create an integer array with 5 elements.
        int [] winningNumbers= new int [5];
        
        // Create an object of the Random class
        Random rnd=new Random(36);
                
        //REPEAT 5 times:
	//Generate a random integer in the range of 0 through 35.
        for (int i=0; i<5; i++) {
            
        //Store the random integer in the array    
        winningNumbers[i]=rnd.nextInt(36);
              
            }       
        //Return the integer array
        return winningNumbers;
        
    }
  
/**
 * Method, which asks user pick five his own numbers
 * @return value of user's numbers
 */
public static int[] getPlayerPicks(){
              
     //ask the user to enter 5 integers in the range of 0 through 35
      System.out.println("Enter any five numbers from 0 to 35: ");
      Scanner scnr = new Scanner(System.in);
      int[] number = new int [5];
      for (int i=0; i<number.length; i++){
       number[i] =scnr.nextInt(); 
             
        if (number[i]>35){
            System.out.println ("One of the choosen number out of range");
          } 
          
      }
        return number; 
     }

/**
 * Method to compare user's numbers that match drop numbers
 * @param arrWin array of drop numbers
 * @param arrPicks user's numbers array 
 * @return number of digits that match
 */
public static int matchNumbers(int [] arrWin,int[] arrPicks){
     int counter=0;
      
      for (int i=0; i<arrWin.length; i++){
            for (int j=0; j<arrPicks.length; j++){
             if (arrWin[i]==arrPicks[j]){++counter;}
        }}
      return counter;}

/**
 * Method to calculate prize depend of digit that match
 * @param n number of mutch digits
 */
public static void calculatePrize(int n){
     if (n==0)
     {System.out.println ("Congratulations! You won $0"); }
      
     if (n==2)
     {System.out.println ("Congratulations! You won $10"); }  
     
     if (n==3)
     {System.out.println ("Congratulations! You won $50"); } 
     
     if (n==4)
     {System.out.println ("Congratulations! You won $250"); } 
     
     if (n==5)
     {System.out.println ("Congratulations! You won Jackpot"); } 
                   
    }
 /**
  * Method which first finds out the number of matching digits and 
  * then display the prize amount that player won.  
  * @param win array of drop numbers
  * @param pick array of user's numbers
  */
public static void calculatePrize(int [] win,int[] pick) {
    
    matchNumbers(win,pick);
    calculatePrize(matchNumbers(win,pick));
    
}
}

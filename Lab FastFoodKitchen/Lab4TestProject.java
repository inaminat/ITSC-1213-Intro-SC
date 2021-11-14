/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4testproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Iryna Naminat
 */
public class Lab4TestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //BurgerOrder order1=new BurgerOrder (3,5,4,10,false,1);
        //BurgerOrder order2=new BurgerOrder (0,0,3,3,true,2);
        //BurgerOrder order3=new BurgerOrder (1,1,0,2,false,3);
        //System.out.println(order1);
       // System.out.println(order2);
       //System.out.println(order3);
        
        
        //order1.setNumSodas(12);
         //System.out.println(order1);
        
       
        
        
        
        FastFoodKitchen kitchen = new FastFoodKitchen();
        Scanner sc = new Scanner(System.in);

        while (kitchen.getNumOrdersPending() != 0) {
            // see if user wants to add an order
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Order food");
            System.out.println("\t 2. Check on an order");
	    System.out.println("\t 3. Show all the orders currently pending.");
            System.out.println("\t 4. Do nothing (just waiting)");
            System.out.println("\t 5. Cancel the order");
            System.out.println("\t 6. Change the prise");
           int i=0,k=0;
            try {
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("How many hamburgers do you want?");
                        int ham = sc.nextInt();
                        System.out.println("How many cheeseburgers do you want?");
                        int cheese = sc.nextInt();
                        System.out.println("How many veggieburgers do you want?");
                        int veggie = sc.nextInt();
                        System.out.println("How many sodas do you want?");
                        int sodas = sc.nextInt();
                        System.out.println("Is your order to go? (Y/N)");
                        char letter = sc.next().charAt(0);
                        boolean TOGO = false;
                        if (letter == 'Y' || letter == 'y' ) {
                          TOGO = true;
                          
                          System.out.println("Your payment is: ");  
                          double payment = sc.nextInt();
                          BurgerOrder order =new BurgerOrder(ham,cheese,veggie,sodas,TOGO,kitchen.addOrder(ham, cheese, veggie, sodas, TOGO));
                          System.out.println("Your change is: $"+(payment-order.getOrderCost()));
                        
                                  }
                        else
                          break;
                         
                        
                        int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                        System.out.println("Thank-you. Your order number is " + orderNum);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("What is your order number?");
                        int order = sc.nextInt();
                        boolean ready = kitchen.isOrderDone(order);
                        if (ready) {
                            System.out.println("Yes, we already called out order number " + order);
                        } else {
                            System.out.println("No, it's not ready, but it should be up soon. Sorry for the wait.");
                        }
                        System.out.println();
                        break;
                        
			case 3: 
			    System.out.println(kitchen);
			    break;
                    case 4:
                        break;
                    default:
                        System.out.println("Sorry, but you need to enter a 1, 2, 3 or a 4");
                        
                    case 5:
                     System.out.println("What is your order number?");
                     int number = sc.nextInt();                 
                     boolean cancel= kitchen.cancelOrder(number);
                        if (cancel){
                         System.out.println("Your order has been successfully cancelled");}
                        else{
                        System.out.print("Sorry, we can’t find your order number in the system");
                        break; }
                        
                    case 6:
                     System.out.println("What is new Humburger prise?");
                     double newhumburgerPrise = sc.nextInt(); 
                     BurgerOrder.setBurgerPrice(newhumburgerPrise);
                     System.out.println("Humburger new prise is: "+newhumburgerPrise);
                     
                     System.out.println("What is new Cheeseburger prise?");
                     double newcheesburgerPrise = sc.nextInt(); 
                     BurgerOrder.setCheeseburgerPrice(newcheesburgerPrise);
                     System.out.println("Cheeseburger new prise is: "+newcheesburgerPrise);
                      
                     System.out.println("What is new Soda prise?");
                     double newsodaPrise = sc.nextInt(); 
                     BurgerOrder.setSodaPrice(newsodaPrise);
                     System.out.println("Soda new prise is: "+newsodaPrise);
                     
                     System.out.println("What is new Veggieburger prise?");
                     double newveggieBurgerPrice = sc.nextInt(); 
                     BurgerOrder.setVeggieBurgerPrice(newveggieBurgerPrice);
                     System.out.println("Veggieburger new prise is: "+newveggieBurgerPrice);
                        break;
                  
                } 
            }
            
        catch (InputMismatchException ime) {
                System.out.println("Sorry, but that wasn't a number.");
            }
            // simulate cooking activity in the kitchen
            kitchen.simulateKitchenActivity();
            
    } // end while loop
        
        System.out.println("" );
    }
    
}

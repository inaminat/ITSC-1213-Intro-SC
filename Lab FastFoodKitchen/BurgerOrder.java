package lab4testproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iryna Naminat
 */
public class BurgerOrder {
    
private int numHamburgers=0;
private int numCheeseburgers=0;
private int numVeggieburgers=0;
private int numSodas=0;
private boolean orderToGo=false;
private int orderNum = 10;
       
static double burgerPrice=2.00;
static double cheeseburgerPrice=1.50;
static double veggieBurgerPrice=1.0;
static double sodaPrice=0.50;


    public BurgerOrder(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum) {
        this.numHamburgers=numHamburgers;
        this.numCheeseburgers=numCheeseburgers;
        this.numVeggieburgers=numVeggieburgers;
        this.numSodas=numSodas;
        this.orderToGo=orderToGo;
        this.orderNum=orderNum;
                  
    }
 
    /**
     * Get the value of numHamburgers
     *
     * @return the value of numHamburgers
     */
    public int getNumHamburgers() {
        return numHamburgers;    }

    /**
     * Set the value of numHamburgers
     *
     * @param numHamburgers new value of numHamburgers
     */
    public void setNumHamburgers(int numHamburgers) {
        this.numHamburgers = numHamburgers;
        if   (numHamburgers<=0){
        System.out.println("Error. Number of Humburgers can't be negative");
        }
    }


    /**
     * Get the value of numCheeseburgers
     *
     * @return the value of numCheeseburgers
     */
    public int getNumCheeseburgers() {
        return numCheeseburgers;
    }
    /**
     * Set the value of numCheeseburgers
     *
     * @param numCheeseburgers new value of numCheeseburgers
     */
    public void setNumCheeseburgers(int numCheeseburgers) {
        this.numCheeseburgers = numCheeseburgers;
        if   (numCheeseburgers<=0){
        System.out.println("Error.Number of Ceeseburgers can't be negative");
            }
    }
    
       /**
     * Get the value of numVeggieburgers
     *
     * @return the value of numVeggieburgers
     */
    public int getNumVeggieburgers() {
        return numVeggieburgers;
    }

    /**
     * Set the value of numVeggieburgers
     *
     * @param numVeggieburgers new value of numVeggieburgers
     */
    public void setNumVeggieburgers(int numVeggieburgers) {
       
        this.numVeggieburgers = numVeggieburgers;
        if   (numVeggieburgers<=0){
        System.out.println("Error.Number of Veggieburgers can't be negative");
        }
    }

       /**
     * Get the value of numSodas
     *
     * @return the value of numSodas
     */
    public int getNumSodas() {
        return numSodas;
    }

    /**
     * Set the value of numSodas
     *
     * @param numSodas new value of numSodas
     */
    public void setNumSodas(int numSodas) {
        this.numSodas = numSodas;
        if   (numSodas<=0){
        System.out.println("Error.Number of Soda can't be negative");
    }
}
   
      /**
     * Get the value of orderToGo
     *
     * @return the value of orderToGo
     */
    public boolean isOrderToGo() {
        return orderToGo;
    }
    
      /**
     * Set the value of orderToGo
     *
     * @param orderToGo new value of orderToGo
     */
    public void setOrderToGo(boolean orderToGo) {
        this.orderToGo = orderToGo;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
   

    
    @Override
    public String toString() {
        return "BurgerOrder{" + "numHamburgers=" + numHamburgers + ", numCheeseburgers=" + numCheeseburgers + ", numVeggieburgers=" + numVeggieburgers + ", numSodas=" + numSodas + ", orderToGo=" + orderToGo + ", orderNum=" + orderNum + '}';
    }
    
    //----------- LAB 6----------------

    public static double getBurgerPrice() {
        return burgerPrice;
    }

    public static double getCheeseburgerPrice() {
        return cheeseburgerPrice;
    }

    public static double getVeggieBurgerPrice() {
        return veggieBurgerPrice;
    }

    public static double getSodaPrice() {
        return sodaPrice;
    }

    public static void setBurgerPrice(double burgerPrice) {
        BurgerOrder.burgerPrice = burgerPrice;
    }

    public static void setCheeseburgerPrice(double cheeseburgerPrice) {
        BurgerOrder.cheeseburgerPrice = cheeseburgerPrice;
    }

    public static void setVeggieBurgerPrice(double veggieBurgerPrice) {
        BurgerOrder.veggieBurgerPrice = veggieBurgerPrice;
    }

    public static void setSodaPrice(double sodaPrice) {
        BurgerOrder.sodaPrice = sodaPrice;
    }
    
    //method that will get the total cost of a BurgerOrder, and return the value. 
    
    public double getOrderCost(){
    double totalCost=numHamburgers*getBurgerPrice()+numCheeseburgers*getCheeseburgerPrice()+
            numVeggieburgers*getVeggieBurgerPrice() +numSodas*getSodaPrice(); 
    return totalCost;
     }
   }

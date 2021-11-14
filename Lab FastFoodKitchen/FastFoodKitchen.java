package lab4testproject;


import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iryna Naminat
 */
public class FastFoodKitchen {
    
    private ArrayList<BurgerOrder> orderList  = new ArrayList<>();
    private static int nextOrderNum;
    
    
    public FastFoodKitchen() {
        
    orderList.add(new BurgerOrder(3, 5, 4, 10, false, getNextOrderNum()));
    incrementNextOrderNum();
    
    orderList.add(new BurgerOrder(0,0,3,3,true, getNextOrderNum()));
    incrementNextOrderNum();
    
    orderList.add(new BurgerOrder(1,1,0,2,false, getNextOrderNum()));
    incrementNextOrderNum();
        
    }
    
   
    /**
     * Get the value of nextOrderNum
     *
     * @return the value of nextOrderNum
     */
      
    
    private static void incrementNextOrderNum(){
          nextOrderNum++; 
       }    
            
    public static int getNextOrderNum() {
        return nextOrderNum;
    }

public int addOrder(int ham, int cheese, int veggie, int soda, boolean ToGo){
    
   BurgerOrder newOrder = new BurgerOrder(ham,cheese,veggie,soda,ToGo, getNextOrderNum());
   System.out.println ("Your total is: $"+newOrder.getOrderCost());

   orderList.add(newOrder);
   int orderID=getNextOrderNum();
   incrementNextOrderNum();
   return orderID;
   
   } 

public boolean isOrderDone(int orderID){
for(BurgerOrder order: orderList){
    if(order.getOrderNum()==orderID){
        return false;}
   }
return true;
}

private void orderCallout(BurgerOrder ordercall){
    for(BurgerOrder order: orderList){
      if(order.getNumHamburgers()==ordercall.getNumHamburgers()||
              order.getNumCheeseburgers()==ordercall.getNumCheeseburgers()||
              order.getNumVeggieburgers()==ordercall.getNumVeggieburgers()|| 
              order.getNumSodas()==ordercall.getNumSodas());
      { System.out.println (order);}
    }
}

private void completeSpecificOrder(int orderID){
 for(BurgerOrder order: orderList)
       {
           if(order.getOrderNum()== orderID)
               {System.out.println("Order is done!");
               if(order.isOrderToGo())
                   orderCallout(order);
               //removes order
               orderList.remove(order);
               }
       }
}
private void completeNextOrder(){
      BurgerOrder order1=orderList.get(0);
       System.out.println("Order is done!");
       if(order1.isOrderToGo())
           orderCallout(order1);
       orderList.remove(order1);
}
public int getNumOrdersPending(){
 return orderList.size();
}
public void simulateKitchenActivity(){ // we give you this code
        // see if there is anything to do
        if (orderList.size() == 0) return; 
        // simulate how orders are completed, usually 
       // first-in, first-out, but not always
       int num = (int)(Math.random()*100);
       if (num < 90) {
  // 90% chance the kitchen completes the order that is at
  // the front of the completeNextOrder();
       } else {
  // complete some random order
int size = orderList.size();
int id = (int)(Math.random()*size);
completeSpecificOrder(id);}
}

    @Override
    public String toString() {
        return "FastFoodKitchen{" + "orderList=" + orderList + '}';
    }
     
    
    // ---------------LAB 6--------------
    public boolean cancelOrder(int orderID){
        //Iterate through orderList, checking each order
         for(BurgerOrder order: orderList){
         /*If there is an order in the list whose order number matches orderID, 
         remove the order  from the orderList and return true */   
         if(order.getOrderNum()== orderID){
         orderList.remove(orderID);
         return true; }
         }
          return false;
    }
    
    
}

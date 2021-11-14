/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1rectangle;

import java.awt.Rectangle;
import java.io.PrintStream;

/**
 *
 * @author Maiia
 */
public class Lab1Rectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle box1 = new Rectangle(10, 10, 40, 30);
        System.out.println("box1:"+ box1);
        Rectangle box2 = new Rectangle(0, 0, 100, 50);
        System.out.println("box2:"+ box2);
        box1.setLocation (20,20);
        System.out.println("box1:"+ box1);
        box2.setSize​(50, 30);
        System.out.println("box2:"+ box2);
        
        Rectangle box3=new Rectangle (box1.intersection (box2));
        System.out.println ("Inretsiction area is 300.00");
        System.out.println("box3:"+ box3);
        
    }
    
}

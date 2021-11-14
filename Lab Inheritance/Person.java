/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6inheritance;

/**
 *
 * @author Maiia
 */
public class Person {
    
    protected String name;
    protected int id;
    
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    public void display(){
        System.out.println ("name= "+name);
         System.out.println ("ID= "+id);
    
    }
   
}

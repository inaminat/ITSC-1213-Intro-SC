/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6inheritance;

import java.util.ArrayList;

/**
 *
 * @author Maiia
 */
public class Student extends Person {
    
     public Student(String name, int id, String major, double gpa) {
        super(name, id);
        this.major=major;
        this.gpa=gpa;
    }
     
  private String major;
  private double gpa;
  
  
  private ArrayList<String> enrolledClasses= new ArrayList<>();

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public ArrayList<String> getEnrolledClasses() {
        return enrolledClasses;
    }

   public void addClass(String name) {
   enrolledClasses.add(name);
   }
   
   public boolean dropClass(String name){
       
       return true;
}

     @Override
   public void display(){
   super.display();
   System.out.println ("Student major: "+major);
   System.out.println ("Student GPA: "+gpa);
   
   System.out.println ("Enrolled in the following classes: " + enrolledClasses);
   
   }


}

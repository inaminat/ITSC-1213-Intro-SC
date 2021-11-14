/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6inheritance;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Maiia
 */
public class Professor extends Person{
    
    public Professor(String name, int id, String department,double salary) {
        super(name, id);
        this.department=department;
        this.salary=salary;
        
    }
    
    
    private String department;
    private double salary;
    private ArrayList<Student> advisees= new ArrayList<Student>();

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public ArrayList<Student> getAdvisees() {
        return advisees;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void addAdvisee(Student student){
        advisees.add(student);
        
    }
    
    public boolean removeAdvisee(String name){
        for (Student k: advisees){
         if (k.getName()==name){
        advisees.remove(k);
        return true;
           }
       }
       return false;   
    }
    
    
    @Override
    public void display(){
    super.display();
    
     System.out.println("Department="+ department);
     System.out.println("Salary="+ salary);
     
   
    System.out.println("Advisees: ");
    for (Student name:advisees){
    System.out.println (name.getName());
    }
    }
    
}

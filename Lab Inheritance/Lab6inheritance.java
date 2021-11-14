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
public class Lab6Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Person p = new Person("Alice", 1000);
       // p.display();
        
        
   /*  Student s1 = new Student("Bob", 900, "CS", 3.5);
    s1.addClass("Java Programming");
    s1.addClass("Calculus");
   if (s1.dropClass("Spanish"))
   System.out.println("The class has been dropped");
 else
System.out.println("You are not enrolled in the class");
 s1.display();
 */
 
 Student s1 = new Student("Bob", 900, "CS", 3.5);
Student s2 = new Student("Catherine", 901, "CS", 3.2);
Student s3 = new Student("Dylan", 902, "CS", 3.0);

Professor p1 = new Professor("Mary", 300, "CS", 80000);
p1.addAdvisee(s3);
p1.addAdvisee(s2);
p1.addAdvisee(s1);
p1.display();

if(p1.removeAdvisee("John"))
System.out.println("The advisee has been removed");
else

System.out.println("The advisee cannot be found in the list");
if(p1.removeAdvisee("Bob"))
System.out.println("The advisee has been removed");
else
System.out.println("The advisee cannot be found in the list"); 
    }  
}

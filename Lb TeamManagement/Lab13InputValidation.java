/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab13inputvalidation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MC Lane
 */
public class Lab13InputValidation {
    private static String strConfirmDialogMessage = "";
    private static String strConfirmDialogTitle = "";
    private static int intConfirmDialogValue;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InfoModel myModel = new InfoModel();
        StartFrame myFrame = new StartFrame(myModel);
        myFrame.setTitle("StartFrame");
        myFrame.setVisible(true);
        
//        intConfirmDialogValue = JOptionPane.showConfirmDialog(null,
//                                                  strConfirmDialogMessage,
//                                                  strConfirmDialogTitle, 
//                                                  JOptionPane.YES_NO_OPTION);
//        System.out.print("The ConfirmDialog user's choice is ");
//        if (intConfirmDialogValue == JOptionPane.YES_OPTION)
//            System.out.println("YES (" + intConfirmDialogValue + ").");
//        else if (intConfirmDialogValue == JOptionPane.NO_OPTION)
//            System.out.println("NO (" + intConfirmDialogValue + ").");
           
        
    }
    
}

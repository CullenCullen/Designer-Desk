/**
 * Author: Cullen Shortt
   This program calculates the cost of constructing desks for customers.
   It uses a switch statement, if-else statements, and the conditional operator. 
   Loops were not allowed to be used.
   After completing their first desk, the program asks users if they would like to create another 
   desk. The TestDesk class collects user input and works with the Desk class.
    
*/
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
   
   public class TestDesk {

   public static void main(String [] args) {
      
     double desk1Cost;
     double desk2Cost;
     double totalDeskCost;
     
     Desk desk1 = createDesk();  //method call to get user input and create desk object
     desk1Cost = calculatePrice(desk1);
     
     //Formats the output price of the desks
     DecimalFormat formatter = new DecimalFormat("$0.00");
                   
     
      //JOptionPane.showInputDialog(null, desk1 +"\nTotal Deskcost: " + desk1Cost, JOptionPane.INFORMATION_MESSAGE);
      JOptionPane.showInternalMessageDialog(null, desk1 +"\nDeskcost: " + formatter.format(desk1Cost),"Information", JOptionPane.INFORMATION_MESSAGE);
            
            if (JOptionPane.showConfirmDialog(null, "Would you like to create another desk?","choose one",
               JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               Desk desk2 = createDesk();
               desk2Cost = calculatePrice(desk2);
               totalDeskCost = desk1Cost + desk2Cost;

               JOptionPane.showInternalMessageDialog(null, desk1 +"\nDeskcost: " + formatter.format(desk1Cost) + "\n" + desk2 +"\nDeskcost: " + formatter.format(desk2Cost) + 
               "\n\nTotal Number of desks = " + desk2.count + "\n\nTotal cost of desks: " + formatter.format(totalDeskCost)+ "\nAverage Price: " +
               formatter.format((desk1Cost + desk2Cost) /2) , "Information", JOptionPane.INFORMATION_MESSAGE);
               System.exit(0);
        
               } else {
               
               System.exit(0);
               }  

      
   }
   
   public static Desk createDesk() {  //change void to Desk 
   
     String lengthString;
      float length; //represents inches
     String widthString;
      float width; //represents inches
     String typeString;
       char type; //valid values P,O,M,p,o,m
     String drawersString;  
        int drawers;
        
       
         lengthString = JOptionPane.showInputDialog(null, "What length, in inches, would you like your desk to be?",
         "Desk Length", JOptionPane.QUESTION_MESSAGE);
        //converts userinput from a String value into a float value and stores in variable.
         length = Float.parseFloat(lengthString);
         
       widthString = JOptionPane.showInputDialog(null, "What width, in inches, would you like your desk to be?",
         "Desk Width", JOptionPane.QUESTION_MESSAGE);
        //converts userinput from a String value into a float value and stores in variable.
         width = Float.parseFloat(widthString);
       
       typeString = JOptionPane.showInputDialog(null, "What wood type would you like your desk to be?\n\nEnter in:\n P or p for Pine\n O or o for Oak\n M or m for Mahogany",
         "Desk Wood Type", JOptionPane.QUESTION_MESSAGE);
        //converts userinput from a String value into an integer value and stores in variable.
       type = typeString.charAt(0); //since the JOptionPane class only accepts Strings, this line gets the first character from the user.
       if(type != 'P'&& type!= 'p' && type != 'M' && type!= 'm')  //If the user inputs an incorrect desk type it defaults to Oak.
               {type = 'O';}
       
       drawersString = JOptionPane.showInputDialog(null, "How many drawers would you like your desk to have? Minimum is 1",
         "Desk Drawers", JOptionPane.QUESTION_MESSAGE);
        //converts userinput from a String value into a float value and stores in variable.
         drawers = Integer.parseInt(drawersString);
         if(drawers < 1) 
         {drawers = 1;}
        return new Desk(length,width,type,drawers);  
    
   }
   
      public static double calculatePrice(Desk d) {
         
         double pineFrame = 12.50;
         double oakFrame = 26.00;
         double mahoganyFrame = 37.75;
         double largeDeskFee = 18.25;
         double totalDeskCost = 0; 
         double addedDrawerCost = 9.50;
         
         //switch statements that adds frametype cost to the total desk cost. 
         switch(d.getType())
         {
            case 'P':
            case 'p':
               totalDeskCost = pineFrame;
               break;
            case 'o':
            case 'O':
               totalDeskCost = oakFrame;
               break;
            case 'm':
            case 'M':
               totalDeskCost = mahoganyFrame;
            break;
         
         } 
         //conditional operator that adds price for a large desk to total desk cost
         totalDeskCost = (d.getArea() > 75) ? totalDeskCost + largeDeskFee : totalDeskCost;
         
         //if else statements that add the drawer price to the desk total cost
         if(d.getDrawers() == 1) {
            totalDeskCost = totalDeskCost;
         }else if(d.getDrawers() >= 6) {
            totalDeskCost = totalDeskCost + addedDrawerCost * 6;
         }else {
            totalDeskCost = totalDeskCost + (addedDrawerCost * d.getDrawers() - 9.50);
         }
         
         return totalDeskCost;
         // Create a DecimalFormat object.
           //     DecimalFormat formatter = new DecimalFormat("$0.00");
//                return formatter.format(totalDeskCost);  
                  
      }


}
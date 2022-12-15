/**
 * Author: Cullen Shortt
   This class creates Desk objects based on user input from the TestDesk class. 
   It has has a default constructor and a default constructor with predetermined values. 
*/

   public class Desk {

      //Instance Variable
      private float length; //represents inches
      private float width; //represents inches
      private char type; //valid values P,p,O,o,M,m
      private int drawers;
      
      //static variable
      public static int count = 0;  //tracks the number of desks created
      
      //Instance Methods
      
      public Desk() { //default constructor
         length = 6;
         width = 12;
         type = 'O';
         drawers = 1;
         count++;
      }
      
      public Desk(float length, float width, char type, int drawers) { //constructor with 4 arguments
      
          this.length = length;
          this.width = width;
          this.type = type;
          this.drawers = drawers;
          count++;
      }

      public float getArea() { //a method to calculate and return the area of a desk
      
          return this.length * this.width;
      }
      
      public char getType() { //A method to return desk type
         
         return this.type;
      }
      
      public int getDrawers() { // A method to return the number of drawers
         
         return this.drawers;
      }
      
      public String toString() { //Displays the object's attributes
         
         return "Desk \nType: " +getType() + "\nDrawers " + getDrawers() + "\nTotal Area = " + getArea() +"\n";    
         
      } 
}
package vishalP;

import java.util.Scanner;

public class Switch {

	public static void main (String args[]) {
		
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the week name");
	 String week=sc.next();
	
	 switch(week) {
	 case "Monday":
		 System.out.println ("HEllo");
		 break;
	
	 case "Sunday": {
		 
		 System.out.println("hello1");
		 break;
	
	 }
	 default : 
		 System.out.println("Enter the valid week");
	}
	}
}

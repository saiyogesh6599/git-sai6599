package vishalP;

import java.util.Scanner;

class PushException extends Exception {
	public String toString() {
		return "Stack is full";
	}
}
class PopException extends Exception {
	public String toString() {
		return "stack is empty";
	}
}
	
class TestArray {
	
	int A[]=new int[4];
	int count=0;
	 	void Push () throws PushException {
	 		if (count>=A.length) {
	 			throw new PushException();
	 		}
		Scanner sc=new Scanner(System.in);
		while (A.length ==count) {
		System.out.println ("Enter the number");
		int user=sc.nextInt();
		A[count]=user;
		count++;
		System.out.println("pushed elements are :"+ user);
		break;
}	
	 	}
	 	 void displayStack() {
	         System.out.println("Stack elements:");
	         for (int i = 0; i < count; i++) {
	             System.out.print(A[i] + " ");
	         }
	         System.out.println();
	     }
}
public class StackNew {

	public static void main (String args[]) throws PushException {
		
		TestArray t=new TestArray();
		t.Push();
//		t.displayStack();
	
	}
}



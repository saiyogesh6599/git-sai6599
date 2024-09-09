package vishalP;

import java.util.Scanner;

class PushException extends Exception {
		
public String toString (){
		return "Stack is full";
	}
}

class ArrayPush {
	
	int A[]=new int[4];
	int count=-1;
	
	void pushArray(int x) throws PushException{
		if (count==A.length-1) 
			throw new PushException();
		count++;
		A[count]=x;
	}
}


public class StackUdemy {

	public static void main (String args[]) throws PushException {
		ArrayPush a=new ArrayPush();
		try {	
		a.pushArray(10);
		a.pushArray(10);
		a.pushArray(10);
		a.pushArray(10);
		a.pushArray(10);
//		a.pushArray(10);
		} catch (PushException e) {
			System.out.println(e);
		}
	}
}

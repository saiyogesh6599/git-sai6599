package vishalP;

import java.util.Scanner;

//Define a custom exception for stack overflow
class PushException extends Exception {
 @Override
 public String toString() {
     return "Stack Overflow: Cannot push more elements.";
 }
}

class TestNew {
 int A[] = new int[4]; // Stack array of size 4
 int count = 0; // Counter to keep track of the number of elements

 // Push method to insert elements into the stack
 void Push() throws PushException {
     if (count >= A.length) { // Check if the stack is full
         throw new PushException(); // Throw custom exception if full
     }
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a number to push onto the stack:");
     int user = sc.nextInt();
     
     // Insert the user input at the current count index
     A[count] = user;
     count++; // Increment the count
     System.out.println("Element pushed: " + user);
 }

 // Method to display the elements in the stack
 void displayStack() {
     System.out.println("Stack elements:");
     for (int i = 0; i < count; i++) {
         System.out.print(A[i] + " ");
     }
     System.out.println();
 }
}

public class StackNew1 {
 public static void main(String args[]) {
     TestNew t = new TestNew(); // Create an instance of the Test class

     try {
         // Allow the user to push up to 4 elements onto the stack
         for (int i = 0; i < 4; i++) {
             t.Push();
             t.displayStack();
         }
         // Attempting to push beyond the capacity of the stack
         t.Push(); // This should trigger a custom exception
     } catch (PushException e) {
         System.out.println(e);
     }
 }
}


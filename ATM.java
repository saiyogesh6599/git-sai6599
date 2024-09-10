package vishalP;

class MyATM {
	
	 synchronized public String checkBalance(String name, int amount) {
		    System.out.println("Thread " + Thread.currentThread().getName() + " is checking balance for: " + name);
	        try {
	            Thread.sleep(1000); // Simulating some processing delay
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return "The customer with name: " + name + " is checking the balance";
	    }
	 synchronized public String checkWithDraw(String name, int amount) {
		    System.out.println("Thread " + Thread.currentThread().getName() + " is withdrawing for: " + name+"the amount"+amount);
	        try {
	            Thread.sleep(1000); // Simulating some processing delay
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return "The customer with name: " + name + " is withdrawing the amount"+amount;
	    }
}
class GetATM extends Thread {
	
	MyATM a;
	String name;
	int amount;
	
	GetATM(MyATM a) {
		this.a=a;
		this.name=name;
		this.amount=amount;
	}
	public void run() {
		a.checkBalance("sai",100);
	}
}
class GetATM1 extends Thread {
	
	MyATM a;
	String name;
	int amount;
	
	GetATM1(MyATM a) {
		this.a=a;
		this.amount=amount;
	}
	public void run() {
		a.checkWithDraw("saiyogesh",1000);
		
	}
}
public class ATM {
	
	public static void main (String args[]) {
		MyATM a=new MyATM();
		GetATM c1=new GetATM(a);
		GetATM1 c2=new GetATM1(a);
		c1.start();
		c2.start();
		
	}

}

package vishalP;

class ThrowTheException extends Exception {	
	 public String toString() {
		return "Correct the details of values";
	}
}
class calculate {
	  calculate() throws ThrowTheException{
		calculate1();
	}
	void calculate1() throws ThrowTheException {
		try {
		int a=calculate2(10,0);
		System.out.println (a);
		} catch (Exception e) {
			System.out.println (""+e.getMessage());
		}	
		throw new ThrowTheException();
		}
	int calculate2(int x,int y)throws ThrowTheException {	
		int a=x/y;
		return a;		
	}
}
public class ThrowsE {
	public static void main (String args[]) throws Exception {
		try {
		calculate c=new calculate();
		} catch (ThrowTheException e) {
			System.out.println(e);
		}
	}
}

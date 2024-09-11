package vishalP;

class GetData{
	int value=0;
	int count=1;
	synchronized void set(int x)   {
		while(count!=1) {
			try {wait();}catch (Exception e) {}}
			value=x;
			count=0;
			System.out.println("Producer is setting the value:"+value);
			notify();
	}
	synchronized int get() {
		int x=0;
		while (count!=0) {
			try {wait();}catch (Exception e) {}}
			x=value;
			count=1;
			notify();
			return x;
	}
}
class Producer extends Thread {
	GetData d;
	Producer(GetData d) {
        this.d = d;  // Use the shared instance
    }
	public void run() {
		int x=1;
		while (true) {
			d.set(x);
			x++;
		}	
	}
}
class Consumer extends Thread {
	GetData d;
	Consumer(GetData d) {
        this.d = d;  // Use the shared instance
    }
	public void run () {
		while (true) {
			int value1=d.get();
				System.out.println("Consumer getting the value"+value1);
		}
	}
}
public class InterThread {
	
	public static void main (String args[]) {
		GetData d=new GetData();
		Producer p=new Producer(d);
		Consumer c=new Consumer(d);
		p.start();
		c.start();
	}
}

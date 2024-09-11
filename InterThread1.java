package vishalP;

class MyData {
	
	String text;
	int student=0;
	int writing=0;
	
	synchronized void set(String text1) {
		while(writing!=0) {
			try {wait();}catch (Exception e){}}
			text=text1;
			System.out.println("Teacher is writing :"+text);
			writing=1;
			notify();
	}
	synchronized String get() {
		String name;
		while (writing!=1) {
			try{wait();}catch (Exception e) {}}
		name=text;
		writing=0;
		return name;
	}
}
class Teacher extends Thread {
	String text;
	MyData d;
	String text1="Java is language";
	String text2="it is opps";
	String text3="it supports";
	String text4="end";
	
	Teacher(MyData d) {
		this.d=d;
	}
	public void run(){
		
		while (true) {
			d.set(text1);
			d.set(text2);
			d.set(text3);
	
		}
	}
}
class Student extends Thread {
	MyData d;
	Student(MyData d){
		this.d=d;
	}
	public void run() {
		System.out.println("Stundent is copying :"+d.get());
		System.out.println("Stundent is copying :"+d.get());
		System.out.println("Stundent is copying :"+d.get());
		System.out.println("Stundent is copying :"+d.get());

	}
}

public class InterThread1 {

	public static void main (String args[]) {
		MyData d=new MyData();
		Teacher t=new Teacher(d);
		Student s=new Student(d);
		t.start();
		s.start();
		
		String name[]={"saiYogesh"};
		int m1=10;
		int i=Integer.parseInt("1234");
		System.out.println("value"+name.toString());
		System.out.println(Float.floatToIntBits(i));
		System.out.println(Integer.valueOf(m1).hashCode(m1));
		System.out.println(i);
		
	}
}

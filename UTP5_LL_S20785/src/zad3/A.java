package zad3;

public class A implements Runnable {
	Thread t;
	CommodityManager cm;
	
	A(){
	  t = new Thread(this, "A");
	  cm = new CommodityManager();
	}

	public void run(){
		cm.producer();
	}
	
	public void start() {
		t.start();
	}
}

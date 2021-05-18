package zad3;

public class B implements Runnable{
	Thread t;
	CommodityManager cm;

	B(){
	  t = new Thread(this, "B");
	  cm = new CommodityManager();
	}

	public void run(){
		cm.counter();
	}
	
	public void start() {
		t.start();
	}
	
}

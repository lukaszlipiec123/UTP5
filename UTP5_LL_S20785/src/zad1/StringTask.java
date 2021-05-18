package zad1;

public class StringTask implements Runnable {
	Thread t;
	String baseStr;
	int howManyConcats;
	String output = "";
	TaskState taskState;
	boolean isDone;
	boolean suspendFlag;
	
	StringTask(String str, int howManyConcats){
		t = new Thread(this, "Thread");
		this.baseStr = str;
		this.howManyConcats = howManyConcats;
		this.taskState = TaskState.CREATED;
		this.isDone = false;
	}
	
	public void run() {
		this.taskState = TaskState.RUNNING;
		for(int i = 0; i < howManyConcats; i++) {
			if (Thread.currentThread().isInterrupted()) { 
				this.isDone = true;
				return;
			}
			output += baseStr;
        }
		
		this.isDone = true;
		this.taskState = TaskState.READY;
	}
	
	public TaskState getState() {	
		return this.taskState;
	}
	
	public void start() {
		t.start();
	}
	
	public String getResult() {
		return this.output;
	}
	
	public boolean isDone() {
		return this.isDone;
	}
	
	public void abort() {
		this.taskState = TaskState.ABORTED;
		t.interrupt();
	}
	

}

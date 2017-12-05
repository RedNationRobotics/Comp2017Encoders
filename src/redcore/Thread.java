package redcore;

public class Thread {
	
public static void main(String[] args) throws InterruptedException {
	System.out.println("Main thread starting");
	
	Course calc = new Course();
	for(int i=0; i < 10; i++) {
		System.out.println("Main thread: " + calc._Course);
		Thread.sleep(1000);
	}
	
	System.out.println("Main thread exiting.");
	}

public boolean isAlive() {
	// TODO Auto-generated method 
	return false;
}

public static void sleep(long l) {
	// TODO Auto-generated method stub
	
}

public static void start() {
	// TODO Auto-generated method stub
	
}
}

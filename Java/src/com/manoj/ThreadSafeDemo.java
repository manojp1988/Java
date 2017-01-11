package com.manoj;

public class ThreadSafeDemo {

	public static void main(String[] args) throws InterruptedException {

		//ThreadSafe safe = new ThreadSafe();
		ThreadNotSafe safe = new ThreadNotSafe();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++){
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					safe.increment();
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++){
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					safe.increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	System.out.println("Final value: "+ safe.getCounter());
		
	}

}

class ThreadSafe {
	
	private volatile int counter;
	
	public synchronized void increment(){
		counter++;
		System.out.println(counter);
	}
	
	public int getCounter(){
		return counter;
	}
	
}

class ThreadNotSafe {
	
	private int counter;
	
	public void increment(){
		counter++;
		System.out.println(counter);
	}
	
	public int getCounter(){
		return counter;
	}
}

package com.manoj;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * This class explains the thread safe implementation. 
 */
public class ThreadSafeDemo {

	public static void main(String[] args) throws InterruptedException {

		//ThreadSafe safe = new ThreadSafe(); 
		//ThreadNotSafe safe = new ThreadNotSafe();
		AtomiClass safe = new AtomiClass();
		
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


//This is thread safe class, because counter variable is locked for until increment
// method completed.
class ThreadSafe {
	
	//All values read from memory instead of its own cache. 
	private volatile int counter;
	
	public synchronized void increment(){
		counter++;
		System.out.println(counter);
	}
	
	public int getCounter(){
		return counter;
	}
	
}

//Atomic classes are thread safe. So the counter variable is thread safe. No interleaving occur.

class AtomiClass {
	
		private  AtomicInteger counter = new AtomicInteger(0);
		
		public synchronized void increment(){
			counter.getAndIncrement();
			System.out.println(counter.get());
		}
		
		public int getCounter(){
			return counter.get();
		}
}


//Counter variable is not thread safe. As this can be read/write by two threads at different time.
//Interleaving occurs. So one thread may have a wrong value

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

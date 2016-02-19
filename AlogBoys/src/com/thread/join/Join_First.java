package com.thread.join;

public class Join_First {
	public static void main(String[] args) throws InterruptedException {
		Mythread mythread = new Mythread();
		Thread t1 = new Thread(mythread, "Ravi");
		Thread t2 = new Thread(mythread, "Soni");

		System.out.println("InSide Main Thread: "
				+ Thread.currentThread().getName());

		t1.start();
		t1.join();

		t2.start();
		t2.join();

		System.out.println("End Main Thread: "
				+ Thread.currentThread().getName());
	}
}

class Mythread implements Runnable {
	public void run() {
		System.out.println("Start Run Method of Thread: "
				+ Thread.currentThread().getName());
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
		System.out.println("End Run Method of Thread: "
				+ Thread.currentThread().getName());
	}
}

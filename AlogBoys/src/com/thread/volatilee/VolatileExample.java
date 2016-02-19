package com.thread.volatilee;

public class VolatileExample {

	private static volatile int x = 0, y = 0;

	private static void method1() {
		x++;
		y++;
	}

	private static void method2() {
		System.out.println("x=" + x + " y=" + y);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 15; i++) {
					method1();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 15; i++) {
					method2();
				}
			}
		};

		t1.start();t1.yield();
		t2.start();t2.join();

	}

}

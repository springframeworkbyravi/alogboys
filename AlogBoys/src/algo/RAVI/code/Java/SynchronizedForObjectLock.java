package algo.RAVI.code.Java;

public class SynchronizedForObjectLock {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "Ravi");
		Thread t2 = new Thread(myThread, "Soni");

		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable {
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " thread is exceuting for: " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {

				}
			}

		}
	}
}

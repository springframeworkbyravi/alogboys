package algo.RAVI.code.Java;


/**
 * Write a program to create deadlock between two threads.
 * 
 * @author ravikson
 * 
 * @Description Deadlock describes a situation where two or more threads are
 *              blocked forever, waiting for each other. Deadlocks can occur in
 *              Java when the synchronized keyword causes the executing thread
 *              to block while waiting to get the lock, associated with the
 *              specified object. Since the thread might already hold locks
 *              associated with other objects, two threads could each be waiting
 *              for the other to release a lock. In such case, they will end up
 *              waiting forever.
 * 
 */
public class MyDeadlock {

	String str1 = "Ravi";
	String str2 = "Soni";

	public static void main(String[] args) {
		MyDeadlock myDeadlock = new MyDeadlock();
		myDeadlock.thread1.start();
		myDeadlock.thread2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hii");
	}

	Thread thread1 = new Thread("Thread One") {
		public void run() {
			while (true) {
				synchronized (str1) {
					System.out.println("Thread 1: locked resource 1");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str2) {
						System.out.println("Thread 1: locked resource 2");
						System.out.println(str1 + " " + str2);
					}
				}
			}
		}
	};

	Thread thread2 = new Thread("Thread two") {
		public void run() {
			while (true) {
				synchronized (str2) {
					System.out.println("Thread 2: locked resource 2");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str1) {
						System.out.println("Thread 2: locked resource 1");
						System.out.println(str1 + " " + str2);
					}
				}
			}
		}
	};

}

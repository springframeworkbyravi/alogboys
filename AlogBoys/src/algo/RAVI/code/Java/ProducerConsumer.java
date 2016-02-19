package algo.RAVI.code.Java;

import java.util.ArrayList;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		Producer producer = new Producer();
		Consumer consumer = new Consumer(producer);

		Thread pThread = new Thread(producer, "Producer");
		Thread cThread = new Thread(consumer, "Consumer");

		cThread.start();
		Thread.sleep(1000);
		pThread.start();
	}

}

class Producer implements Runnable {
	ArrayList<Integer> shareList;

	Producer() {
		shareList = new ArrayList<Integer>();
	}

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				shareList.add(i);
				System.out.println("Producer is still producing, produced: "
						+ i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			System.out.println("Production is over, consumer can consume.");
			this.notify();
		}
	}
}

class Consumer implements Runnable {

	Producer producer;

	Consumer(Producer producer) {
		this.producer = producer;
	}

	public void run() {

		synchronized (this.producer) {
			System.out.println("Consumer waiting for producer to get over");
			try {
				this.producer.wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			int prodSize = this.producer.shareList.size();
			for (int i = 0; i < prodSize; i++) {
				System.out.println("Consumed: "
						+ this.producer.shareList.remove(0) + " ");
			}
		}
	}
}
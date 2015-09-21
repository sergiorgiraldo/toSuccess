

import java.util.concurrent.*;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		myBlockingQueue<Integer> bq = new myBlockingQueue<Integer>(10);
		
		Producer p = new Producer(bq);
		Consumer c = new Consumer(bq);
		
		new Thread(p).start();
		new Thread(c).start();
		
	}
}

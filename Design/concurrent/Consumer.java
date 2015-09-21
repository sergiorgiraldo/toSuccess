

import java.util.concurrent.*;

public class Consumer implements Runnable{
	
	private myBlockingQueue bq;
	
	public Consumer(myBlockingQueue bq) {
		
		this.bq = bq;
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub	
		try {
			
			for(int i = 0; i < 10; ++i){
				
				System.out.println("Consumer takes: " + bq.take());
				
			}
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}	
	}
	
}

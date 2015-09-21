
import java.util.Random;
import java.util.concurrent.*;

public class Producer implements Runnable{
	private myBlockingQueue bq;
	
	public Producer(myBlockingQueue bq) {
		
		this.bq = bq;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			
			Random rd =  new Random();
			
			for(int i = 0; i< 10; ++i) {
				
				int val = rd.nextInt(100);		
				System.out.println("Producer puts:  " + val);
				bq.put(val);
				Thread.sleep(50);
			}
			
		}catch (InterruptedException e ) {
			
			e.printStackTrace();
			
		}
	}
}

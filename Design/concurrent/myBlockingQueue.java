
public class myBlockingQueue<T> {
	
	int capacity = 0;
	T[] bucket;
	int size = 0;
	
	public myBlockingQueue(int capacity) {
		
		this.capacity = capacity;
		bucket = (T[]) new Object[capacity];
		
	}
	
	public synchronized void put( T val) throws InterruptedException {
		
		if (size == this.capacity) {	
			wait();
		}
		
		if(size == 0) { // only those producer is blocked by invoking this method
			notifyAll();
		}
		
		bucket[size] = val;
		size++;
	}
	
	public synchronized T take() throws InterruptedException {
		
		if(size == 0) {
			wait();
		}
		
		if(size == this.capacity) {
			notifyAll();
		}
		
		T val = bucket[size - 1];
		size--;
		return val;
	}
}

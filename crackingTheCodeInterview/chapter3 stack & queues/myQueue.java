/*
Implement a MyQueue class which implements a queue using two stacks.
*/
import java.util.*;

// how to poll & peek efficiently ? general cases 1) push push push.... pop  1) push push pop pop push pop 
//  when keep pushing into s1, when pop|| peek, if s2 not empty, peek|| poll s2, otherwise get everything from s1 (clear s1).
public class myQueue{
    
    Stack<Integer> s1= new Stack<Integer>();
    Stack<Integer> s2= new Stack<Integer>();

    public void offer( int val){
    	s1.push(val);
    }

    public void poll(){
    	if(!s2.isEmpty())
    		System.out.println(s2.pop());
    	else{
    		while(!s1.isEmpty())
    			s2.push(s1.pop());
    		System.out.println(s2.pop());
    	}
    }
    
    public void peek(){
    	if(!s2.isEmpty())
    		System.out.println(s2.peek());
    	else{
    		while(!s1.isEmpty())
    			s2.push(s1.pop());
    		System.out.println(s2.peek());
    	}
    }

    public boolean isEmpty(){
    	return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args){
        myQueue q= new myQueue();
        for(int i=0; i<6; ++i)
        	q.offer(i);
        q.poll();
        q.peek();

        q.offer(10);
        q.offer(11);
        
        q.peek();
        q.poll();
 
    }
    
}
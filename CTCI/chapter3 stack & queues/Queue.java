/*Implement a queue using LinkedList */

import java.util.*;

public class Queue{
    
    
	 class LinkedListNode{
	 	int val;
	 	LinkedListNode next;
	 	public LinkedListNode(int val){
	 		this.val= val;
	 	}
	 }    

	 LinkedListNode head, tail;
	 int size;

	 public Queue(){
	 	size =0;
	 }
	 public boolean isEmpty(){
		 return size==0;
	 }
	 
	 public void offer(int val){
	 	LinkedListNode node=  new LinkedListNode(val);
	 	if(size==0){
	 		head = node;
	 		tail = node;
	 	}else{
	 		tail.next= node;
	 		tail= tail.next;
	 	}
	 	size++;
	 }

	 public int poll(){
	 	if(size==0){
	 		System.out.println("empty");
	 		return -1;
	 	}else{

	 		int res= head.val;
	 		head= head.next;
	 		size--;
	 		return res;
	 	}
	 		
	 }

	 public int peek(){
	 	if(size==0){
	 		System.out.println("empty");
	 		return -1;
	 	}else{
	 		return head.val;
	 	}
	 }
	 @Override
	 public String toString(){
		 LinkedListNode cur= head;
		 StringBuilder res= new StringBuilder();
		 while( cur != null){
			 res.append(cur.val+" ");
			 cur= cur.next;
		 }
		 System.out.println(res.toString());
		 return res.toString();
	 }
	    
   public static void main(String[] args){
      Queue q= new Queue();
      for(int i=0; i<10; ++i)
    	  q.offer(i);
      q.toString();
      
      for(int i=0; i<10; ++i){
    	  System.out.println(q.peek());
    	  q.poll();   	  
      }
      q.toString();
   }
   
}
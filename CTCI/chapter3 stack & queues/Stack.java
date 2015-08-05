/*Implement a stack using Array ? */

import java.util.*;

public class Stack{
    
    int[] st;
    int Maxsize;
    int top;

    public Stack(int n){
       Maxsize= n;
       st= new int[Maxsize];
       top=0;
   }

   public boolean isEmpty(){
   	return 0==top;
   }

   public void push(int val){
   	if(top== Maxsize){
   		System.out.println("full");
   		return;
   	}  		
   	st[top]=val;
   	top++;
   }

   public int pop(){
   	if(this.isEmpty()){
   		System.out.println("empty");
   		return -1;
   	}
   	int val= st[top-1];
   	st[top-1]=0;
   	top--;
   	return val;
   }

   public int peek(){
   	if(top==0){
   		System.out.println("empty");
   		return -1;
   	}
   	int val= st[top-1];
   	return val;
   }

   @Override
   public String toString(){
   	StringBuilder res= new StringBuilder();
   	int count=top;
   	while(count != 0){
   		res.append(st[count-1] + " ");
   		count--;
   	}
   	return res.toString();
   }
   public static void main(String[] args){
       
       Stack s= new Stack(9);
       for(int i=0; i<10; ++i){
       	s.push(i);
       }
       System.out.println(s.toString());

       for(int i=0; i<10; ++i){
       	 System.out.println(s.peek());
       	 s.pop();
       }

   }
   
}
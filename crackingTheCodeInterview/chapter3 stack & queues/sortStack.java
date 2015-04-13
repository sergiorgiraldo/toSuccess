/*
Write a program to sort a stack in ascending order. 
You should not make any assumptions about how the stack is implemented. 
The following are the only functions that should be used to write this program: 
push | pop | peek | isEmpty.

*/

import java.util.*;

public class sortStack{
	// auxil is the ordered stack
	// every time pop a element from s, if auxil's top not consistently ordered with the element, keeping pop auxil and add to s
	// then add the elment to auxil, which is in order with the left elements
     static Stack<Integer> auxil = new Stack<Integer>();
	     public static void sort(Stack<Integer> s){    
	         System.out.println(s.toString());
	         while(!s.isEmpty()){
	         	int tmp= s.pop();
	         	while(!auxil.isEmpty() && auxil.peek() < tmp )
	         		s.push(auxil.pop());
	         	auxil.push(tmp);
	         }

	         System.out.println(auxil.toString());
	    }
	    
     public static void main(String[] args){
	        Stack<Integer> s = new Stack<Integer>();
	        Random rd = new Random();
	        rd.setSeed(System.currentTimeMillis());
	        for (int i = 0; i < 10; i++) {
	           s.push(rd.nextInt(10));
	        }
	        sort(s);
	 
	    }

    
}
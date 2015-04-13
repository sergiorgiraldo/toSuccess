/*
How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
push, pop and min should all operate in O(1) time.
*/

import java.util.*;

public class minStack{
    
    /*
    One stack solution: 
    The idea is to store the gap between the min value and the current value;
    Since the possible gap between the current value and the min value could be Integer.MAXVALUE-Integer.MINVALUE;
    */
	long min;
    Stack<Long> stack = new Stack();

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
        	if (x<min) min=x;
            stack.push(x-min);//Could be negative if min value needs to change
            
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
   
   public static void main(String[] args){
       
       minStack s= new minStack();
       s.push(1);
       s.push(5);
       s.push(7);
       s.push(0);   
       s.push(2);
       
       s.pop();
       System.out.println(s.top());
       s.pop();
       System.out.println(s.top());
       s.pop();
       System.out.println(s.top());
   }
   
}
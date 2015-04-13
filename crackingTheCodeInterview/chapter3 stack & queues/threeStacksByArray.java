/**
    * Describe how you could use a single array to implement three stacks
 */
import java.util.*;

// how to divide the array ?
/*
Approach 1:
Divide the array in three equal parts and allow the individual stack to grow in that limited space (note: “[“ means inclusive, while “(“ means exclusive of the end point).
»»for stack 1, we will use [0, n/3)
»»for stack 2, we will use [n/3, 2n/3)
»»for stack 3, we will use [2n/3, n)
*/
public class threeStacksByArray{
    
    int[] arr;
    int[] top= new int[3];
    int size;
    public threeStacksByArray(int size){
    	// not check size if valid here
    	this.size= size;
    	arr = new int[size];
    	top[0]= 0;
    	top[1]= size/3;
    	top[2]= size*2/3;
    }

    public void push(int stacknum, int val){
    	if(isFull(stacknum)){
    		throw new IllegalArgumentException(stacknum + " is full");
    	}
    	
    	arr[top[stacknum]]= val;
    	top[stacknum]++;
    }

    public void pop(int stacknum){
    	if(this.isEmpty(stacknum)){
    		throw new IllegalArgumentException(stacknum +" is empty");
    	}
    	int val= arr[top[stacknum]-1];
    	arr[top[stacknum]-1]=0;
    	top[stacknum]--;
    	System.out.println(val);
    }

    public boolean isEmpty(int stacknum){
    	if(stacknum==0)
    		return top[stacknum]==0;
    	else if(stacknum==1)
    		return top[stacknum]==size/3;
    	else
    		return top[stacknum]== size*2/3;
    	
    }
    
    public boolean isFull(int stacknum){
    	if(stacknum==0)
    		return top[stacknum]==size/3;
    	else if(stacknum==1)
    		return top[stacknum]==2*size/3;
    	else
    		return top[stacknum]== size;
    	
    }
    
    public void peek(int stacknum){
    	if(this.isEmpty(stacknum)){
    		throw new IllegalArgumentException(stacknum +" is empty");
    	}
    	int val= arr[top[stacknum]-1];
    	System.out.println(val);
    }

    public static void main(String [] args){
    	threeStacksByArray s= new threeStacksByArray(12);

    	for(int i=0; i<4; ++i){
    		s.push(0, i);
    		s.push(1, i+4);
    		s.push(2, i+8);
    	}

    	for(int i=0; i<4; ++i){
    		s.pop(0);
	
    		s.pop(1);
	
    		s.pop(2);
    	}
    }
}
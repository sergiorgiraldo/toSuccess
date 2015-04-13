/*
Implement a data structure SetOfStacks. SetOfStacks should be composed of several stacks, 
and should create a new stack once the previous one exceeds capacity. 
SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
(that is, pop() should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

import java.util.*;

public class setOfStacks{

	int capacity;
	ArrayList<Stack<Integer>> sets;

    public setOfStacks(int capacity){
    	this.capacity= capacity;
    	sets= new ArrayList<Stack<Integer>>();
    }
    
    public void push(int val){
    	if( sets.size()==0 || sets.get(sets.size()-1).size()== capacity){
    		Stack<Integer> tmp = new Stack<Integer>();
    		tmp.push(val);
    		sets.add(tmp);
    	}else{
    		sets.get(sets.size()-1).push(val);
    	}
    }

    public void pop(){
    	if(sets.size()==0)
    		return;
    	// remove empty stacks and get last valid stack
    	int idx= sets.size()-1;
    	while(idx >=0){
    		if(sets.get(idx).size()==0){
    			sets.remove(idx);
    			idx= sets.size()-1;
    		}
    		else
    			break;
    	}
    	// pop
    	sets.get(idx).pop();
    	
    	// remove empty stacks and get last valid stack
    	idx= sets.size()-1;
    	while(idx >=0){
    		if(sets.get(idx).size()==0){
    			sets.remove(idx);
    			idx= sets.size()-1;
    		}
    		else
    			break;
    	}
    }
    
 // the stack is not required to be full in this implementation
    public void popAt(int idx){
    	if(idx <0 || idx >= sets.size())
    		return;
    	if(sets.get(idx).size()==0){
    		//sets.remove(idx);
    		return;
    	}else{
    		sets.get(idx).pop();
    	}
    }

    public void printSets(){
    	int count= sets.size();
    	for(Stack s: sets){
    		System.out.println("elements in " + count +"th stack");
    		System.out.println(s.toString());
    		count--;
    	}
    }
    public static void main(String[] args){
        
        setOfStacks s= new setOfStacks(2);
        for(int i=0; i< 18; ++i){
        	s.push(i);
        }
        s.printSets();
        System.out.println("----------");
        for(int i=0; i< 12; ++i){
        	s.pop();
        }
        s.printSets();
        
        System.out.println("----------");
        s.popAt(6);
        s.popAt(5);
        s.popAt(4);
        s.popAt(3);
        s.popAt(2);
        s.popAt(1);
        s.popAt(0);
        s.printSets();
        
        System.out.println("----------");
        for(int i=0; i< 3; ++i){
        	s.pop();
        }
        s.printSets();
        
    }
    
}
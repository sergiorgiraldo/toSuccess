/*
In the classic problem of the Towers of Hanoi, you have 3 rods and N disks. 
You have the following constraints:
(A) Only one disk can be moved at a time.
(B) A disk is slid off the top of one rod onto the next rod.
(C) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first rod to the last using Stacks.
*/

import java.util.*;

public class hanoiTower{
    
    Stack<Integer> disks;
    int index;
    int ID;
   
	public  hanoiTower(int i, int id){
    	disks= new Stack<Integer> ();
    	index = i;
    	ID= id;
    }

    public int index(){
    	return index;
    }

    public void add(int d){
    	if(!disks.isEmpty() && disks.peek() <= d){
    		System.out.println( " can not move this disk ");
    		return;
    	}
    	else
    		disks.push(d);
    }

    public void moveTopTo(hanoiTower t){
    	int top= disks.pop();
    	t.add(top);
    	System.out.println("move disk " + top + " from tower " + this.ID + "'s index "+
    			index() + " to " + "tower "+ t.ID + "'s index " + t.index());
    }

    public void print(){
    	System.out.println("Contents of Tower " + this.ID+":  " );
    	for(int i= disks.size()-1; i>=0; --i )
    		System.out.print(" " + disks.get(i));
    }
    
    public void moveDisks(int n, hanoiTower destination, hanoiTower buffer){
    	if(n >0 ){
    		moveDisks(n-1, buffer, destination);
    		moveTopTo(destination);
    		buffer.moveDisks(n-1, destination, this);
    	}
    }
    public static void main(String[] args){
    	int n=5;
    	hanoiTower[] towers= new hanoiTower[3];

    	for (int i = 0; i < 3; i++) {
         towers[i] = new hanoiTower(5, i);
      	}

      	for (int i = n-1; i >= 0; i--)
         towers[0].add(i);
      	
      	towers[0].moveDisks(n, towers[2], towers[1]);
      	
      	for (int i = 0; i < 3; i++)
      		towers[i].print();
 
    }
    
}
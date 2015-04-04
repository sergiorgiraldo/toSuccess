/*
 Coin Change
Something cost $10.25 and the customer pays with a $20 bill, the program will print out the 
most efficient "change-breakdown" which is 1 five, 4 ones, and 3quarters. Find the minimum number 
of coins required to make change for a given sum (given unlimited cumber of N different denominations coin)
*/

import java.util.*;

public class coinChange{
    static double[] denom={0.01, 0.25, 0.5, 1, 5, 10};
    public static void getNum(double target){
        int[] change= new int[denom.length];
       
        for(int i= denom.length-1; i>=0; --i){
        		if(target >= denom[i]){
        			change[i]= (int)(target/denom[i]);
        			target= target - denom[i]* change[i];
        		}
        }
        for(int i=0; i< change.length; ++i){
        	System.out.println("number of denom " + denom[i] +" is : " + change[i]);

        }


        
    }
    
    public static void main(String[] args){
        getNum(20 - 10.25);
        System.out.println();
        
    }
    
}
/*

22. Find Max/Min Number
Take a series of integers as input till a zero is entered. Among these given integers, 
find the maximum of the odd numbers and the minimum of the even integers (not including zero) and print them.

*/

import java.util.*;
import java.io.*;

class findMaxMin{
    
    public static void find(int[] input){
    	int mine=Integer.MAX_VALUE, maxo= Integer.MIN_VALUE;
        for(int i=0; i< input.length; ++i){
        	if(input[i]==0)
        		break;
        	if(input[i] % 2 ==0){
        		mine= Math.min(mine, input[i]);
        	}else
        		maxo= Math.max(maxo, input[i]);
        }
        System.out.println("The min for even values is: "+ mine + "  and the max for odd value is: " + maxo);
        
    }
    
    public static void main(String[] args) throws IOException{
        
       /* Scanner sc= new Scanner(System.in);
        int[] input= new int[100];
        int i=0;
        while(!sc.hasNext("0")){
        	input[i]=Integer.parseInt(sc.next());
        	i++;
        }*/

        // round2
        int[] input = new int[100];
        //ArrayList<Integer> input= new ArrayList<Integer>();
        Scanner in= new Scanner(System.in);
        int i=0;
        while(!in.hasNext("0")){
            int val= Integer.parseInt(in.next());
            input[i]=val;
            i++;
        }
        //int[] arr= input.toArray(new int[input.size()]);

        find(input);
        
    }
    
}
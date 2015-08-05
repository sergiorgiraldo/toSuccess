/*
Given quarters(25), dimes(10), nickels(5) and pennies(1), write a function to find all ways to generate n cents
*/

import java.util.*;

public class makeChange{
    
     public static void generate(int n){

        helper(new ArrayList<String>(), new int[4], 0, n);
         System.out.println();
     }
     public static void helper(ArrayList<String> res, int[] path, int sum, int n){
     	if(sum==n){
     		System.out.println(Arrays.toString(path));
     		String s="";
     		s+=path[0]+path[1]+path[2]+path[3];
     		res.add(s);
     		return;
     	}
     	if(sum>=n)
     		return;
     	if(sum+25 <= n){
     		path[0]++;
     		helper(res, path, sum+25, n);
     		path[0]--;
     	}
     	if(sum+10 <= n){
     		path[1]++;
     		helper(res, path, sum+10, n);
     		path[1]--;
     	}
     	if(sum+5 <= n){
     		path[2]++;
     		helper(res, path, sum+5, n);
     		path[2]--;
     	}
     	if(sum+1 <= n){
     		path[3]++;
     		helper(res, path, sum+1, n);
     		path[3]--;
     	}

     }
    
    public static void main(String[] args){
        
        generate(10);
 
    }
    
}
 /* climbing stairs, 1, 2, or 3 steps at a time. How many possible ways*/

import java.util.*;

public class climbingStairs{
    // recursive solution is O(3^n) + , while dp is O(n) + O(n)
    // n>=37 ---> overflow
    public static void helper(int n){
        int [] dp= new int[n+1];
        dp[0]= 1;
        dp[1]=1;
        dp[2]= 2;

        for(int i=3; i<=n; ++i ){

        	dp[i]= dp[i-1] + dp[i-2] +dp[i-3];
        }

         System.out.println(dp[n]);
    }

    // reduce space usage
    public static void helper2(int n){
      
    	int a=1, b=1, c=2;
        for(int i=3; i<=n; ++i ){
        	int d= a+b+c;
        	int t1= c;
        	c=d;
        	int t2= b;
        	b= t1;
        	a= t2;
        }

         System.out.println(c);
    }
    public static void main(String[] args){
        
        helper(20);
 		helper2(20);
    }
    
}
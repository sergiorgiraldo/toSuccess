package ll;
/*
Palindromes
Print all palindromes of size greater than or equal to 3 of a given string. (How to do it with DP)?
*/
import java.util.*;

public class palindrome{
    // dp[i][j], palindrome covers i to j
	// dp[i][j] = dp[i+1][j-1] and s(i)= s(j) || j-i <2 and s(i)= s(j)
    public static void find(String s){
        int n= s.length();
        boolean [][] dp= new boolean[n][n];
        // backward dp
        /*for(int i=n-1; i>=0; --i){
        	for(int j=i; j<n; ++j){
        		if((j-i<=2 || dp[i+1][j-1]) && s.charAt(i)==s.charAt(j)){
        			dp[i][j]=true;
        		} 
        		if(dp[i][j]){
        			if(j-i+1 >=3){
        				System.out.println(s.substring(i, j+1));
        			}
        		}
        	}
        }*/
        // forward dp
        for(int i=0; i<n; ++i){
        	for(int j=0; j<=i; ++j){
        		if((i-j <=2 || dp[j+1][i-1]) && s.charAt(i)== s.charAt(j) ){
        			dp[j][i]= true;
        		}
        		if(dp[j][i]){
            		if(i-j+1 >=3){
            			System.out.println(s.substring(j, i+1));
            		}
            	}	
        	}
        }
    }
    
    public static void main(String[] args){
        find("bbbbaaaacccc");
        System.out.println();
        
    }
    
}
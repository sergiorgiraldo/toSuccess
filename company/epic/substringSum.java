/*
Substring Addition
Write a program to add the substring. eg :say you have alist {1 7 6 3 5 8 9 } and user is entering a sum 16. Output should display(2-4) that is {7 6 3} cause 7+6+3=16.
*/

import java.util.*;

public class substringSum{
    
    public static void find(String list, int target){
        
        /*for(int i=0; i< list.length(); ++i){
        	int sum=0;
        	for(int j=i; j<list.length(); ++j){
        		sum+= list.charAt(j)-'0';
        		if(sum == target)
        			System.out.println((i+1)+"-"+(j+1));
        		else if(sum > target)
        			break;
        	}
        }*/

        // more efficient
        int start=0, sum=0;
        for(int i=0; i<list.length(); ++i){
        	while(start < i && sum > target){
        		sum= sum- (list.charAt(start)-'0');
        		start++;
        	}
        	if(sum==target)
        		System.out.println((start+1)+"-"+(i));

        	sum+=list.charAt(i)-'0';
        }
        	

        
    }
    
    // round2
    public static void find2(String s, int target){
        int n= s.length();
        //if(n==0) return;
        int start= 0;
        int sum=0;
        for(int i=0; i< n; ++i){
            while(start < i && sum > target){
                sum= sum- (s.charAt(start)-'0');
                start++;
            }
            if(sum== target)
                System.out.println((start+1)+"-"+(i));

            sum+= s.charAt(i) -'0';
        }
    }
    public static void main(String[] args){
        find2("1763589", 16);
        System.out.println();
        
    }
    
}
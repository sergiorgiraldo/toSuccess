/* A magic index in an array  A[1..n-1] is defined to be an index such that A[i]= i. 
Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A

FOLLOW UP:
What if the values are not distinct? */

import java.util.*;

public class magicIndexBinarySearch{
    
    public static void helper1(int[] arr){
        int l=0, r= arr.length-1;
        while(l <= r){
        	int m= l+ (r-l)/2;
        	if(arr[m] == m ){
        		System.out.println(arr[m]);
        		break;
        	}
        	else if(arr[m] < m){
        		l= m+1;
        	}else
        		r= m-1; 
        }
        System.out.println();
   }
	public static void helper2(int[] arr){
        int l=0, r= arr.length-1;
        while(l < r){ // notice the difference
        	int m= l+ (r-l)/2;
        	if(arr[m] == m ){
        		System.out.println(arr[m]);
        		break;
        	}
        	else if(arr[m] < m){
        		l= m; // notice the difference
        	}else
        		r= m; // notice the difference
        }
        System.out.println();
   }
	
	public static void helper3(int[] arr){
		 int l=0, r= arr.length-1;
	        while(l < r){ 
	        	int m= l+ (r-l)/2;
	        	if(arr[m] == m ){
	        		System.out.println(arr[m]);
	        		break;
	        	}
	        	else if(arr[m] < m){
	        		l= Math.max(arr[m], m); 
	        	}else
	        		r= Math.min(arr[m], m);
	        }
	        System.out.println();
   }
	
   
   public static void main(String[] args){
       int arr[]={-40, -20, -1, 1, 2, 3, 5,7, 9, 12, 13};
       // compare
       helper1(arr);
       helper2(arr);
       int arr2[]={-10, -5, 2, 2, 2, 3, 4,7, 9, 12, 13};
       // duplicates
       helper3(arr2);
   }
    
}
import java.util.*;
public class chapter9{
    
    /* climbing stairs, 1, 2, or 3 steps at a time. How many possible ways*/
    public static int problem9_1(int n){
        int [] dp=new int[n+1];
        dp[0]=1; // i dont know why
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=3; i<=n; ++i){
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
        
    }
    
    /* Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only move in two directions:
     right and down. How many possible paths are there for the robot to go from (0, 0) to (X, Y) ?
     FOLLOW UP
     Imagine certain spots are "off limits," such that the robot cannot step on them.
     Design an algorithm to find a path for the robot from the top left to the bottom right.*/
    public static int problem9_2( int m, int n){
        int[][] dp=new int[m][n];
        for(int i=0; i<n; ++i){
            dp[0][i]=1;
        }
        for(int i=0; i<m; ++i){
            dp[i][0]=1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; ++j){
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
                
            }
        }
        return dp[m-1][n-1];
    }
    
    /* A magic index in an array  A[1..n-1] is defined to be an index such that A[i]= i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A
     FOLLOW UP:
     What if the values are not distinct? */
    public static int problem9_3( int [] A){
     // naive is to scan the whole array, which is O(N)
    // can be better if use binary search, condition is A[mid]< mid, for no-duplicates
        int left = 0, right = A.length - 1;
        
        while(left <= right){
            int mid=(left + right) / 2;
            if(A[mid] == mid)
                return mid;
            else if ( A[mid] < mid )
                left = mid + 1;
            else
                right = mid - 1;
        
        }
        return -1;
    }
    // if have duplicates
    // search both side with a trick
    // can not use iterative binary search, since we need to search in parallelize, and both sides may lead to solution
    public static int problem9_3_dup( int [] A, int left, int right){
        // naive is to scan the whole array, which is O(N)
        // can be better if use binary search, condition is A[mid]< mid, for no-duplicates
        if(left< 0 || right >A.length || left > right )
            return -1;
        
        int mid=(left + right) / 2;
        
        if(A[mid] == mid)
            return mid;
        if( A[mid] > mid){
            // search left
            left= Math.min( A[mid], mid -1 );
            return problem9_3_dup( A, left, right);
        }else{
            // search right
            right= Math.max( A[mid], mid +1 );
            return problem9_3_dup( A, left, right);
        }
        
    }

    
    /* Write a method to return all subsets of a set */
    public static ArrayList<ArrayList<Integer>> problem9_4( ArrayList<Integer> set){
        // recursion
        // scan the input one by one, add a new integer to every previoud subset and union the previous subsets,  we get a newer subsets.
        // do not forget the empty set !
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>()); // add the empty one
        for(int i=0; i< set.size(); ++i){
            ArrayList<ArrayList<Integer>> prev= new ArrayList<ArrayList<Integer>>(res);
            int cur= set.get(i);
            for(int j=0; j<prev.size(); ++j){
                prev.get(j).add(cur);
            }
            res.add(prev);
        }
        return res;
    }
    
    /* you have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit id at the head of the list, write a function that adds the two numbers and returns the sum as a linked list*/
    public static void problem9_5(){
        
        
    }
    
    /* Given a circular linked list, implement an algorithm which returns the node at the begining of the loop*/
    public static void problem9_6(){
        
        
    }
    
    /* Implement a function to check if a linked list is a palindrome */
    public static void problem9_7(){
        
        
    }
    
    public static void main(String[] args){
        int[] A= {-40, 1, 1, 1, 2, 3, 4, 6, 7, 8, 11}; //1, 7, 9
        
        //int res= problem9_3(A);
        //int res= problem9_3_dup(A, 0, A.length-1);
        ArrayList<Integer> s= new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> res= problem9_4(s);
        System.out.println(res.toString());
        
    }
    
    
    
}
/*
Matrix Position
Given an NxN matrix with unique integers :Find and print positions of all numbers such that it is the biggest in its row and also the smallest in its column . e.g. : In 3 x 3 with elements
1 2 3
4 5 6
7 8 9
the number is 3 and position (1,3)
*/

import java.util.*;

public class matrixPosition{
    
    public static void findall(int n){
        
        
    }
    
    public static void main(String[] args){
        int[][] arr= new int[10][10];
        for(int i=0; i<arr.length; ++i)
        	for(int j=0; j< arr[0].length; ++j)
        		arr[i][j]= (int)Math.random()*100;
        findall(arr);
        System.out.println();
        
    }
    
}
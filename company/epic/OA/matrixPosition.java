
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
    
    public static void findall(int[][] arr){

    	printMatrix(arr);
    	int n= arr.length;
        int[] minInCol= new int[n];
        for(int c=0; c< n; ++c){
        	minInCol[c]=Integer.MAX_VALUE;
        	for(int r=0; r<n; ++r){
        		minInCol[c]= Math.min(minInCol[c], arr[r][c]);
        	}
        }
        for(int r=0; r<n; ++r){
        	int max= Integer.MIN_VALUE;
        	int maxc=-1;
        	for(int c=0; c<n; ++c){
        		if(arr[r][c] > max){
        			max= arr[r][c];
        			maxc=c;
        		}
        	}
        	if(max == minInCol[maxc])
				System.out.println("max in row, min in col,  found in positon( " + r +"," + maxc+" ), value is: "+ max);
        }
    }
    // round2
    public static void findall2(int[][] arr){
        int n= arr.length;
        printMatrix(arr);
        int[] maxInRow= new int[n];

        for(int i=0; i< n; ++i){
            int max=Integer.MIN_VALUE;
            for(int j=0; j<n; ++j){
                max= Math.max(max, arr[i][j]);
            }
            maxInRow[i]= max;
        }

        for(int j=0; j< n; ++j){
            int min=Integer.MAX_VALUE;
            int minidx=-1;
            for(int i=0; i<n; ++i){
                if(arr[i][j] < min){
                    min= arr[i][j];
                    minidx= i;
                }
            }
            if(maxInRow[minidx]== min)
                System.out.println(min);
        }
    }

    public static void printMatrix(int[][] matrix){
    	   System.out.println();
    	   for(int i=0; i<matrix.length; ++i){
    	      System.out.print("\n");
    	      for(int j=0; j<matrix[0].length; ++j)
    	         System.out.print(matrix[i][j] + " ");
    	 }
    	 System.out.println();
    	}

    public static void main(String[] args){
        int[][] arr= new int[3][3];
        for(int i=0; i<arr.length; ++i)
        	for(int j=0; j< arr[0].length; ++j)
        		arr[i][j]= (int)(Math.random()*100);
        findall2(arr);
        System.out.println();
        
    }
    
}
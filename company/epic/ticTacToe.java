package ll;
/*
Tic Tac Toe
N*N matrix is given with input red or black.You can move horizontally, vertically or diagonally. 
If 3 consecutive same color found, that color will get 1 point. So if 4 red are vertically then point is 2. 
Find the winner.
 */
import java.util.*;

public class ticTacToe{
	static int redscore=0, blackscore=0, n=0;
	static HashSet<Integer>  visited= new HashSet<Integer>();
	
    public static void find(int[][] matrix){
        
       for(int i=0; i< n; ++i){
    	   for(int j=0; j< n; ++j){
    		   printMatrix(matrix);
    		   if(matrix[i][j] !=-1){ // has been visited
    			   visited= new HashSet<Integer>();
    			   visited.add(i*10000+j);
    	  
    		   }
    	   }
       }
       
       System.out.println("red score: "+ redscore +", and blackscore: " +blackscore);
    }
   
    
    public static int getScore(int count){
    	int score=0;
    	int four= count/4;
    	score+=2*four;
    	count= count- four*4;
    	int three= count/3;
    	score+=three;
    	return score;
    }
    
    public static void printMatrix(int[][] matrix){
 	   System.out.println();
 	   for(int i=0; i<n; ++i){
 	      System.out.print("\n");
 	      for(int j=0; j<n; ++j)
 	         System.out.print(matrix[i][j] + " ");
 	 }
 	 System.out.println();
 	}
    public static void main(String[] args){
        int[][] matrix= new int[5][5];
        n= matrix.length;
        for(int i=0; i< n; ++i){
        	for(int j=0; j< n; ++j){
        		matrix[i][j]= (int)(Math.random()+0.5);
        	}
        }
        
        printMatrix(matrix);
        System.out.println("-------------");
        find(matrix);
        
        
    }
    
}

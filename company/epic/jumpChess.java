package ll;
/* Jump Chess
There’s a N*N board, two players join the jump game. The chess could go vertically and horizontally. 
If the adjacent chess is opponent player’s and the spot beside that is empty, then the chess could jump to that spot. 
One chess could not been jumped twice. Given the position of the spot on the board, 
write the program to count the longest length that chess could go.*/
import java.util.*;

public class jumpChess{
    static int n=0;
    static int longestJump=0;
    
    public static boolean canJump(int[][] matrix, int i, int j){
    	if(i<0 || j<0|| i>=n || j>=n || matrix[i][j]==1 )
    		return false;
    	longestJump++;
    	boolean res=
    		canJump(matrix, i+2, j) 
    		||canJump(matrix, i-2, j)
    		||canJump(matrix, i, j-2) 
    		||canJump(matrix, i, j+2);
    	if(!res){
    		System.out.println(longestJump);
    		longestJump=0;
    	}   		
    	return res;
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
    	int[][] matrix= new int[3][3];
        n= matrix.length;
        for(int i=0; i< n; ++i){
        	for(int j=0; j< n; ++j){
        		matrix[i][j]= (int)(Math.random()+0.5);
        	}
        }
        printMatrix(matrix);
        canJump(matrix, 0, 0);
        System.out.println(longestJump);
        
    }
    
}
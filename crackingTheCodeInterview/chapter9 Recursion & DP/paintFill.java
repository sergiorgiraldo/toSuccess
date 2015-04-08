/*
 implement the "paint fill" function : given a screen(2-d array), a point and a new color
 fill in the surrounding area until the color changes from the original color( stop when meets an original color)
*/

import java.util.*;

public class paintFill{
     // http://en.wikipedia.org/wiki/Flood_fill
	 // check every time that lcont<n/2, rcont<n/1
	static int rowlen, collen;  
    public static void fill(int[][] matrix, int i, int j){
        rowlen= matrix.length;
        collen= matrix[0].length;
        helper(matrix, i, j);
        
        System.out.println();
   }

   public static void helper(int[][] matrix, int i, int j){
   	if(i<0 || j<0|| i>= rowlen || j>= collen || matrix[i][j]==1 ||matrix[i][j]==2 )
   		return;
   	matrix[i][j]=2;
   	helper(matrix, i+1, j);
   	helper(matrix, i-1, j);
   	helper(matrix, i, j+1);
   	helper(matrix, i, j-1);
   }
   public static void main(String[] args){
       int[][] matrix= {
      	{0, 0, 0, 0},
      	{0, 1, 1, 0},
      	{0, 1, 0, 1},
      	{0, 0, 0, 0}
      	};
       fill(matrix, 0, 0);

   }
    
}
package ll;
/* Fill a “magic square”matrix.
A magic square of order n is an arrangement of the numbers from 1 to n^2 in an n by n matrix with 
each number occurring exactly once so that each row, each column and each main diagonal has the same sum. 
Then should be an odd number. In the middle cell of the top row, fill number 1.Then go to above row and right column, 
and fill following number 2. If it’s out of boundary, go to the opposite row or column. If the next cell is already occupied,
go to the cell below this cell and fill following number. An example of 5*5 grid is like this for the first 9 numbers:
0 0 1 8 0
0 5 7 0 0
4 6 0 0 0
0 0 0 0 3
0 0 0 2 9*/
import java.util.*;

public class magicSquare{
    
    public static void fill(int n){
    	// check input;
        int[][] matrix= new int[n][n];
        int x=0, y= n/2;
        for(int i=1; i<=n*n; ++i ){
        	matrix[x][y]=i;
        	int tmpx=x, tmpy=y;
        	x=x-1 <0 ? n-1 : x-1;
        	y=y+1 >=n ? 0: y+1;
        	if(matrix[x][y]!=0){
        		x=tmpx+1 >= n? 0: tmpx+1;
        		y=tmpy;
        	}  	
        }
        printMatrix(matrix);
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
        fill(7);

        System.out.println();
        
    }
    
}
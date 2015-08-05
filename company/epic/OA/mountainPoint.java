/*
17. Mountain Point
Given a M * N matrix, if the element in the matrix is larger than other 8 elements who stay around it, then named that element be mountain point. Print all the mountain points.
*/
import java.util.*;

public class mountainPoint{
    
     public static void generate(int[][] matrix){
	        int rownum= matrix.length, colnum=matrix[0].length;
	        if(rownum <=2 || colnum<=2)
	            return ;

	        for(int i=1; i<rownum-1; ++i){
	            for(int j=1; j<colnum-1; ++j){
	            if(matrix[i][j] > matrix[i-1][j] &&
	                matrix[i][j] > matrix[i+1][j] &&
	                matrix[i][j] > matrix[i][j-1] &&
	                matrix[i][j] > matrix[i][j+1] &&
	                matrix[i][j] > matrix[i-1][j-1] &&
	                matrix[i][j] > matrix[i-1][j+1] &&
	                matrix[i][j] > matrix[i+1][j-1] &&
	                matrix[i][j] > matrix[i+1][j+1] 
	            )
	            System.out.println(matrix[i][j]);

	            }
	        }
	    }
	    
	    public static void main(String[] args){

	    	int[][] matrix = 
	    			  {{2,4,5,6,7},
					  {4,5,67,3,5},
					  {5,6,7,8,54},
					  {3,4,5,6,8},
					  {3,4,56,4,5}};

	        generate( matrix);
	        System.out.println();

	    }
}
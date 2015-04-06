
/* Jump Chess
There’s a N*N board, two players join the jump game. The chess could go vertically and horizontally. 
If the adjacent chess is opponent player's and the spot beside that is empty, then the chess could jump to that spot. 
One chess could not been jumped twice. Given the position of the spot on the board, 
write the program to count the longest length that chess could go.*/
import java.util.*;
 
public class jumpChess{
    static int n=0;
    static HashSet<Integer> visited= new HashSet<Integer>();
    
    public static int maxJump(int[][] matrix, int i, int j){
    	System.out.println(i+" "+ j);
    	System.out.println(visited);
    	if(i<0 || j<0|| i>=n || j>=n || matrix[i][j]==1 || visited.contains(i*10000+j)  )
    		return 0;  
    	int res=0;
    	visited.add(i*10000+j);
    	int a=0, b=0, c=0, d=0;
    	if(i+1< n && matrix[i+1][j]==1)
    		a=maxJump(matrix, i+2, j) ;
    	if(i-1>=0 && matrix[i-1][j]==1)
    		b=maxJump(matrix, i-2, j) ;
    	if(j+1< n && matrix[i][j+1]==1)
    		c=maxJump(matrix, i, j+2) ;
    	if(j-1>=0 && matrix[i][j-1]==1)
    		d=maxJump(matrix, i, j-2) ;
    	int tmp= Math.max(Math.max(a, b), Math.max(c, d));
    	
    	res=tmp+1;
    	return res;
    }
    // round2
    public static int maxJump2(int[][] matrix, int i, int j){
        if(i<0 || i>=n || j<0 || j>=n || visited.contains(i*10000+j) || matrix[i][j]==1)
            return 0;
        int res=0;
        visited.add(i*10000+j);
        int a= (i+1 <n && matrix[i+1][j]==1)? maxJump2(matrix, i+1, j) : 0;
        int b= (i-1>=0 && matrix[i-1][j]==1)? maxJump2(matrix, i-1, j) : 0;
        int c= (j+1 <n && matrix[i][j+1]==1)? maxJump2(matrix, i, j+1) : 0;
        int d= (j-1 >=0 && matrix[i][j-1]==1)? maxJump2(matrix, i, j-1) : 0;
        int tmp= Math.max(Math.max(a,b), Math.max(c, d));
        return res+=tmp+1;

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
    	int[][] matrix= new int[15][15];
        n= matrix.length;
        for(int i=0; i< n; ++i){
        	for(int j=0; j< n; ++j){
        		matrix[i][j]= (int)(Math.random()+0.5);
        	}
        }
        printMatrix(matrix);
        
        System.out.println(maxJump(matrix, 0, 0));
        
    }
    
}
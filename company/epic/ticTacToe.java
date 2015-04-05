package ll;
/*
Tic Tac Toe
N*N matrix is given with input red or black.You can move horizontally, vertically or diagonally. 
If 3 consecutive same color found, that color will get 1 point. So if 4 red are vertically then point is 2. 
Find the winner.
 */
import java.util.*;
// got problems here

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
    			   searchRow(matrix, i, j);
    			   searchCol(matrix, i, j);
    			   searchDiag(matrix, i, j);
    			   setVisited(matrix);  			  
    		   }
    	   }
       }
       
       System.out.println("red score: "+ redscore +", and blackscore: " +blackscore);
    }
   
    private static void setVisited(int[][] matrix) {
		for(int cord: visited){
			int x= cord/10000;
			int y= cord%10000;
			matrix[x][y]=-1;
		}
		
	}

	public static void searchRow(int[][] matrix, int i, int j ){
    	int value= matrix[i][j];
    	int count=1;
    	
    	// search left row
    	int c=j;
    	while(c-1>=0 && matrix[i][c-1]==value){
    		count++;
    		visited.add(i*10000+c-1);
    		c--;
    	}
    	// search right row
    	c=j;
    	while(c+1<n && matrix[i][c+1]==value){
    		count++;
    		visited.add(i*10000+c+1);
    		c++;
    	}
    	int score= getScore(count);
    	if(value==0){// red
    		redscore+=score;
    	}else{
    		blackscore+=score;
    	}  	
    }
    public static void searchCol(int[][] matrix, int i, int j ){
    	int value= matrix[i][j];
    	int count=1;
    	
    	// search up col
    	int c=i;
    	while(c-1>=0 && matrix[c-1][j]==value){
    		count++;
    		visited.add((c-1)*10000+j);
    		c--;
    	}
    	// search down col
    	c=i;
    	while(c+1<n && matrix[c+1][j]==value){
    		count++;
    		visited.add((c+1)*10000+j);
    		c++;
    	}
    	int score= getScore(count);
    	if(value==0){// red
    		redscore+=score;
    	}else{
    		blackscore+=score;
    	}  	
    }
    
    public static void searchDiag(int[][] matrix, int i, int j ){
    	int value= matrix[i][j];
    	int count=1;
    	
    	// search up diag
    	int x=i, y=j;
    	while(x-1>=0 && y-1>=0 && matrix[x-1][y-1]==value){
    		count++;
    		visited.add((x-1)*10000+y-1);
    		x--;
    		y--;
    	}
    	// search down dia
    	 x=i;
    	 y=j;
    	while(x+1< n && y+1 <n && matrix[x+1][y+1]==value){
    		count++;
    		visited.add((x+1)*10000+y+1);
    		x++;
    		y++;
    	}
    	
    	// search up red diag
    	 x=i;
    	 y=j;
    	while(x-1>=0 && y+1 <n && matrix[x-1][y+1]==value){
    		count++;
    		visited.add((x-1)*10000+y+1);
    		x--;
    		y++;
    	}
    	// search down red dia
    	 x=i;
    	 y=j;
    	while(x+1 <n && y-1 >=0 && matrix[x+1][y-1]==value){
    		count++;
    		visited.add((x+1)*10000+y-1);
    		x++;
    		y--;
    	}
 	
    	int score= getScore(count);
    	if(value==0){// red
    		redscore+=score;
    	}else{
    		blackscore+=score;
    	}  	
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
        int[][] matrix= new int[3][3];
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

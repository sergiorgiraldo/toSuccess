/*
24. Mingo
A random generator (like a speakerstanding in a group housie game calls out a number) generates out any number from 1 to 1000. There is a 10X10 matrix. 
A random generator assigns values to each block of this matrix(within 1 to 1000 obviously).
Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers called out by the speaker,
 its called a 'Mingo'. Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.

*/

 import java.util.*;

 public class mingo{

    static int count=0;
    static boolean diagChecked=false;
    static boolean redDiagChecked=false;

    public static void generate(){
        int [][] matrix= new int[10][10];

        for(int i=0; i<100; ++i){
        	randomFill(matrix);
        	//checkMingo(matrix);
        }        
    }
    public static void randomFill(int[][] matrix){
    	Random rand= new Random();
    	int data=  rand.nextInt(1000) +1;
    	int index= rand.nextInt(100);
    	int row= index/10;
    	int col= index%10;
    	while(matrix[row][col] !=0){// already filled
    		index= rand.nextInt(100);
    		row= index/10;
    		col= index%10;
    	}
    	matrix[row][col]=data;
    	checkMingo(matrix, row, col);
    }
    public static void checkMingo(int[][] matrix, int row, int col){
    	int index=0;
    	// check row
    	while(index < 10 && matrix[row][index]!=0)
    		index++;
    	if(index==10){
    		count++;
    		System.out.println("------This is the " + count +"th mingo for the "+ row+"th row--------------");
    		printMatrix(matrix);
    	}

    	index=0;
    	//check col;
    	while(index<10 && matrix[index][col]!=0)
    		index++;

    	if(index==10){
    		count++;
    		System.out.println("------This is the " + count +"th mingo for the "+ col+"th col--------------");
    		printMatrix(matrix);
    	}

    	// check diag
    	if(!diagChecked){	
           index=0;
           while(index <10 && matrix[index][index]!=0)
              index++;
          if(index==10){
              count++;
              System.out.println("------This is the " + count +"th mingo for the diagonal--------------");
              printMatrix(matrix);
              diagChecked=true;
          }
      }
    	// check red diag
      if(!redDiagChecked){
       index=0;
       while(index<10 && matrix[index][9-index]!=0)
          index++;
      if(index==10){
          count++;
          System.out.println("------This is the " + count +"th mingo for the red diagonal-------------");
          printMatrix(matrix);
          redDiagChecked=true;
      }
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
    generate();
    System.out.println();

}

}
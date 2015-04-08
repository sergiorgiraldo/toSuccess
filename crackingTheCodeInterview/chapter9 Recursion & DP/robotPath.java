 /* Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only move in two directions:
     right and down. How many possible paths are there for the robot to go from (0, 0) to (X, Y) ?
     FOLLOW UP
     Imagine certain spots are "off limits," such that the robot cannot step on them.
     Design an algorithm to find a path for the robot from the top left to the bottom right.*/

import java.util.*;

public class robotPath{
     static int rownum, colnum;
	public static void helper(int[][] matrix){
        rownum= matrix.length;
        colnum= matrix[0].length;
        int[][] dp= new int[rownum][colnum];

        for(int i=0; i< colnum; ++i){
        	if(matrix[0][i] !=1)
        		dp[0][i]= 1;
        	else
        		break;
        }

        for(int i=0; i< rownum; ++i){
        	if(matrix[i][0] !=1)
        		dp[i][0]= 1;
        	else
        		break;
        }

        for(int i=1; i< rownum; ++i){
        	for(int j=1; j< colnum; ++j){
        		if(matrix[i][j] !=1)
        		dp[i][j]= dp[i-1][j] + dp[i][j-1];
        	}
        }
       
        System.out.println(dp[rownum-1][colnum-1]);
        // although it asks for one solution, I'm trying to get all paths
        ArrayList<ArrayList<String>> allpath= new ArrayList<ArrayList<String>>();
        // bottom up DFS
       // findPath(allpath, new ArrayList<String>(), matrix, 0, 0 );
        // top-down DFS
       findPath2(allpath, new ArrayList<String>(), matrix, 3, 3 );
   }
	// here tried buttom-up DFS
	// exactly the same way
   public static void findPath(ArrayList<ArrayList<String>> res, ArrayList<String> path, int [][] matrix, int i, int j){
	   if(i>=rownum || j>= colnum || matrix[i][j] ==1)
	   		return;
	   
	   if(i==rownum-1 && j==colnum-1){
   			path.add(i+"-"+j);
   			//visited.add(i*10000+j);
   			res.add(new ArrayList<String>(path));
   			for(String p: path)
   				System.out.println(p);
   			System.out.println("----------");
   			//visited.clear();
   			return;
   		}
	   	// does not need to check if visited because move down & right will not bring any circles
	   	ArrayList<String> p1= new ArrayList<String>(path);
	   		p1.add(i+"-"+j);	
		ArrayList<String> p2= new ArrayList<String>(path);
			p2.add(i+"-"+j);		   	
	   	findPath(res, p1, matrix, i+1, j);
	   	
	   	findPath(res, p2, matrix, i, j+1);
	   	
   }
   // here tried top-down 
   // need more understanding about backtracking/recursion/DFS
   public static void findPath2(ArrayList<ArrayList<String>> res, ArrayList<String> path, int [][] matrix, int i, int j){
	   if(i<0 || j<0 || matrix[i][j] ==1)
	   		return;
	   
	   if(i==0 && j==0){
   			path.add(i+"-"+j);
   			//visited.add(i*10000+j);
   			res.add(new ArrayList<String>(path));
   			for(String p: path)
   				System.out.println(p);
   			System.out.println("----------");
   			//visited.clear();
   			return;
   		}
	   	
	   	ArrayList<String> p1= new ArrayList<String>(path);
	   		p1.add(i+"-"+j);	
		ArrayList<String> p2= new ArrayList<String>(path);
			p2.add(i+"-"+j);	
			
		findPath2(res, p1, matrix, i-1, j);
	   	findPath2(res, p2, matrix, i, j-1);
	   	
   }
   public static void main(String[] args){
       int[][] matrix= {
       	{0, 0, 0, 0},
       	{0, 1, 1, 0},
       	{0, 0, 0, 1},
       	{0, 0, 0, 0}
       };
       helper(matrix);

   }
    
}
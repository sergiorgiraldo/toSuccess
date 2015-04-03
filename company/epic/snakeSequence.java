/*
Snake Sequence
You are given a grid of numbers. A snake sequence is made up of adjacent numbers such that for each number, the number on the right or the number below it is +1 or -1 its value. For example,
1 3 2 6 8
-9 7 1 -1 2 
1 5 0 1 9 
In this grid, (3, 2, 1, 0, 1) is a snake sequence. Given a grid, find the longest snake sequences and their lengths (so there can be multiple snake sequences with the maximum length).
*/
import java.util.*;

// take care! java's pass by reference is a SOB.
public class snakeSequence{
    static int rownum, colnum;
    static HashSet<Integer> visited= new HashSet<Integer>();
    static String largest= new String();
    static ArrayList<ArrayList<Integer>> allpaths= new ArrayList<ArrayList<Integer>> ();
    
    public static void getLargest(int[][] matrix){
        rownum=matrix.length;
        colnum= matrix[0].length;
        if(rownum==0 || colnum==0) return ;
        
        for(int i=0; i< rownum; ++i){
            for(int j=0; j<colnum; ++j){
                visited= new HashSet<Integer>();
                ArrayList<Integer> path= new ArrayList<Integer>();
                helper(matrix, path, i, j);
            }
        }
        
        for(ArrayList<Integer> p: allpaths){
            System.out.println(p.toString());
        }
    }
    // suppose matrix dimensions far less than 10000
    public static boolean helper(int[][] matrix, ArrayList<Integer> path, int r, int c){
        if(r>=rownum || r<0 || c>=colnum || c<0 ||visited.contains(r*10000+c)){
            return false;
        }
        
        if(path.size()==0)
            path.add(matrix[r][c]);
        else{
            int last= path.get(path.size()-1);
            if(Math.abs(last- matrix[r][c])!=1){
                return false;
            }
            else
                path.add(matrix[r][c]);
        }
        // search in surrounding
        visited.add(r*10000+c);
        boolean res= helper(matrix, path, r+1, c)
        || helper(matrix, path, r-1, c)
        || helper(matrix, path, r, c+1)
        || helper(matrix, path, r, c-1);
        
        if(!res){// can not search any more
            visited.remove(r*10000+c);
            allpaths.add(new ArrayList<Integer>(path));
            path.clear();
        }
        return res;
    }
    
    public static void main(String[] args){
        int[][] matrix={
            {1, 3, 2, 6, 8},
           {3, 4, 1, -1, 2},
            {1, 5, 0, 1, 9},
        };
        
        getLargest(matrix);
        
    }
    
}
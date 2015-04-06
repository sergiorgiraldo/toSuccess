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
    // round2

    public static void getLargest2(int[][] matrix){
        rownum= matrix.length;
        colnum= matrix[0].length;
        HashSet<String> res= new HashSet<String>();
        for(int i=0; i< rownum; ++i){
            for(int j=0; j< colnum; ++j){
                HashSet<Integer> visited= new HashSet<Integer>();
                helper2(res, matrix, "", i, j , visited);
            }
        }
        
        String maxS="";
        for(String s: res){
            if(s.length() > maxS.length())
                maxS= s;
        }
        System.out.println(res);
        System.out.println(maxS);
    }

    public static boolean helper2(HashSet<String> res, int [][] matrix, String path, int i, int j, HashSet<Integer> visited){
        System.out.println(res);
        if(i<0 || i>= rownum || j<0 || j>=colnum || visited.contains(i*10000+j))
            return false;
        
        if(path.length()==0){
            path+= matrix[i][j];
        }else{
            int last= path.charAt(path.length()-1)-'0';
            if(Math.abs(matrix[i][j]- last)!=1)
                return false;
            else
                path+= matrix[i][j];
        }
        visited.add(i*10000+j);
        boolean next= helper2(res, matrix, path, i+1, j, visited)
        || helper2(res, matrix, path, i, j+1, visited);
        if(!next){ // can not search anymore
            if(! res.contains(path))
            res.add(new String(path));
            visited.remove(i*10000+j);
        }
        return next;
    }
    public static void main(String[] args){
        int[][] matrix={
            {1, 3, 2, 6, 8},
           {3, 4, 1, 1, 2},
            {1, 5, 0, 1, 9},
        };
        
        getLargest2(matrix);
        
    }
    
}
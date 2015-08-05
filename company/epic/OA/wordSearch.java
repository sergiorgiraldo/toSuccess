/*
Finding Words
Write a program for a word search. If thereis an NxN grid with one letter in each cell. 
Let the user enter a word and the letters of the word are said to be found in the grid either the letters match vertically, horizontally or diagonally in the grid.
If the word is found, print the coordinates of the letters as output.

*/

import java.util.*;

public class wordSearch{
    static int rownum, colnum;
    public static void search(String word, char[][] matrix){
        rownum= matrix.length;
        colnum= matrix[0].length;
        
        for(int i=0; i<rownum; ++i){
            for(int j=0; j<colnum; ++j){
                ArrayList<Integer> path = new ArrayList<Integer>();
                helper(path, word, matrix,0, i, j);
                if(!path.isEmpty())
                    printResult(path, word);
            }
        }
        
    }
    //dfs
    public static boolean helper(ArrayList<Integer> path, String word, char[][] matrix, int pos, int r, int c){
        if(pos==word.length()){
            return true;
        }
        if(r>= rownum || r<0 || c>=colnum || c<0 ||word.charAt(pos) != matrix[r][c])
            return false;
        if(path.contains(r*1000+c))
            return false;
        path.add(r*1000+c);
        
        boolean res= helper(path, word, matrix, pos+1, r+1, c)
       || helper(path, word, matrix, pos+1, r-1, c)
       || helper(path, word, matrix, pos+1, r, c+1)
       || helper(path, word, matrix, pos+1, r, c-1)
       || helper(path, word, matrix, pos+1, r+1, c+1)
       || helper(path, word, matrix, pos+1, r-1, c-1)
        || helper(path, word, matrix, pos+1, r-1, c+1)
        || helper(path, word, matrix, pos+1, r+1, c-1);
        if(!res){
            path.remove(path.size()-1);
            return false;
        }
        return true;
    }

    // round2 
    public static void search2(String word, char matrix[][]){
        
        rownum= matrix.length;
        colnum= matrix[0].length;
        for(int i=0; i< rownum; ++i){
            for(int j=0; j< colnum; ++j){
                ArrayList<Integer> path= new ArrayList<Integer>();
                HashSet<Integer> visited= new HashSet<Integer> ();
                helper2(matrix, path, 0, word, visited, i, j );
            }
        }

    }
    
    public static boolean helper2(char[][] matrix, ArrayList<Integer> path, int pos, String word, HashSet<Integer> visited, int i, int j){
        if(pos== word.length()){
            printResult(path, word);
            return true;
        }
        if( i<0 || i>=rownum || j<0 || j>= colnum || visited.contains(i*100000+j))
            return false;
        if(word.charAt(pos) != matrix[i][j])
            return false;

        visited.add(i*10000 +j);
        path.add(i*1000+j);
        boolean res= 
           helper2(matrix, path, pos+1, word, visited, i+1, j) 
        || helper2(matrix, path, pos+1, word, visited, i-1, j) 
        || helper2(matrix, path, pos+1, word, visited, i, j+1) 
        || helper2(matrix, path, pos+1, word, visited, i, j-1)
        || helper2(matrix, path, pos+1, word, visited, i+1, j+1) 
        || helper2(matrix, path, pos+1, word, visited, i-1, j-1) 
        || helper2(matrix, path, pos+1, word, visited, i-1, j+1) 
        || helper2(matrix, path, pos+1, word, visited, i+1, j-1);

        if(!res){
            path.remove(path.size() -1);
            visited.remove(i*10000+j);
        } 
        return res;
    }
    public static void printResult(ArrayList<Integer> res, String word){
        System.out.println("----------" + word + "----------" );
        for(int i=0; i< res.size(); ++i){
            int cur= res.get(i);
            int c= cur%1000;
            int r= cur/1000;
            System.out.println(r+" " +c);
        }
        
    }
    
    public static void main(String[] args){
        char[][] matrix={
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'},
        };
        search2("ABCCED", matrix);
        search2("SEE", matrix);
        search2("ABCB",matrix);
    }
    
}

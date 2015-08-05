/*
Spiral Matrix
Given a NXN matrix, starting from the upper right corner of the matrix start printing values in a counter-clockwise fashion.
E.g.: Consider N = 4
 
Matrix= 
{a, b, c, d,
e, f, g, h,
i, j, k, l,
m, n, o, p}

*/

import java.util.*;

public class spiralMatrix{
    
    public static void print(char[][] matrix){
        int rownum=matrix.length, colnum=matrix[0].length;
        if(rownum==0 || colnum==0) return;
        int left=0, right=colnum-1;
        int up=0, bottom=rownum-1;
        
        // round2
        while(true){
            
            // up
            for(int i= right; i>=left; --i)
                System.out.println(matrix[up][i]);
            // left
            for(int i= up+1; i<= bottom; ++i)
                System.out.println(matrix[i][left]);

            // bottom
            for(int i= left+1; i<= right; ++i)
                System.out.println(matrix[bottom][i]);
            // right
            for(int i= bottom-1; i>=up+1; --i)
                System.out.println(matrix[i][right]);

            left++;
            right--;
            up++;
            bottom--;

            if(left > right || up > bottom)
                break;
        }
        
        
        
    }
    
    public static void main(String[] args){
        char[][] matrix={
            {'a','b','c','d'},
            {'e','f','g','h'},
            {'i','j','k','l'},
            {'m','n','o','p'}
        };
        
        print(matrix);
        System.out.println();
        
    }
    
}
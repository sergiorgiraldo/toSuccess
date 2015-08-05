/*
An array A[1 n] contains all the integers from 0 to n except for one number which is missing In this problem, 
we cannot access an entire integer in A with a single operation. The elements of A are represented in binary, 
and the only operation we can use to access them is “fetch the jth bit of A[i]”, which takes constant time
Write code to find the missing integer. Can you do it in O(n) time?

*/

import java.util.*;
// got problems here
public class findMissingNumber{
    
     public static void find(String[] A){
         ArrayList<Character> res= new ArrayList<Character>();
         helper(res, A, 0);
         System.out.println(res);
     }
     public static void helper(ArrayList<Character> res, String[] A, int idx){
        
        if(idx< 0 || idx >32)
            return;
         
        int zerocount=0, onecount=0;
        for(String num: A){
            if(fetch(num, idx)=='1')
                onecount++;
            else
                zerocount++;
        }
        
        if(zerocount <= onecount)
            res.add('0');
        else
            res.add('1');
         
        helper(res, A, idx-1);
     
     }
     public static char fetch(String i, int j){
            return i.charAt(j);
     }
    
    public static void main(String[] args){
        String[]a={"001", "010", "100", "000"};
        find(a);
 
    }
    
}
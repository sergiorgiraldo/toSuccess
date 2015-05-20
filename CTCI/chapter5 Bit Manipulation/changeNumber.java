/*
Write a function to determine the number of bits required to convert integer A to integer B
Input: 31, 14 Output: 2
*/
import java.util.*;

public class changeNumber{
    
     public static void change(int a, int b){
       
        int tmp= a^b; // same bit->0, diff ->1;
        System.out.println(Integer.toBinaryString(tmp));
        
        int res=0;
        for(; tmp !=0; tmp >>=1){
            res+= tmp &1;
        }
        System.out.println(res);
    }
    
    public static void main(String[] args){
        
        change(31, 14);
 
    }
    
}
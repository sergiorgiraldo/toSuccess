/*
An additive sequence is 1,2,3,5,8,13 
where T(n) = T(n-1) + T(n-2) 

An additive sequence number is which when splitted in two different number forms additive seq. 
Ex: 1235813 (split it 1,2,3,5,8,13) 
Ex: 12122436(12,12,24,36) 

A number range is given to you. Find the additive sequence number in that range.
*/
import java.util.*;

public class additiveNumber{
    // determined by the starting two numbers
    public static void generate(int s, int e){
        
        helper(s, e, 0);
    }
    public static void helper(int start, int end, int num){
        if (num > end){  
            return;  
        }  
        if (num > 0 && num > start){  
            System.out.println(num + " ");  
        }  
        for (int i = 1; i < 9; i++){  
            for (int j = 0; j < 9; j++){  
                int test = i + j;  
                if (test <= 9){  
                    helper(start, end, num*1000 + i*100 + j*10 + test); //
                }
            }  
        }
        
    }
    
    public static void main(String[] args){
        generate(1, 1000);
        System.out.println();
        
    }
    
}
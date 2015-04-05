package ll;
/*
Seeds Number
Find the seed of a number. .
Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. find all possible seed for a given number.
 */
import java.util.*;

public class seedNumber{
    
    public static void find(int target){
        for(int i=1; i <= target/2; ++i){
        	if(target%2 !=0)// must be divided
        		continue;
        	String sub= String.valueOf(i);
        	int value=i;
        	for(int j=0; j< sub.length(); ++j){
        		value*=(sub.charAt(j)-'0');
        	}
        	
        	if(value== target)
        		System.out.println(i);
        }
        
    }
    
    public static void main(String[] args){
        find(24);
        System.out.println();
        
    }
    
}
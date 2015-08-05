package ll;
/*
 Security Keypad
There is a security keypad at the entrance of a building. It has 9 numbers 1 – 9 in a 3×3 matrix format.
1 2 3
4 5 6
7 8 9 . 
The security has decided to allow one digit error for a person but that digit should be horizontal or vertical. 
Example: for 5 the user is allowed to enter 2, 4, 6, 8,  or for 4 the user is allowed to enter 1, 5, 7. 
IF the security code to enter is 1478 and if the user enters 1178 he should be allowed. 
Write a function to take security code from the user and print out if he should be allowed or not.

*/
import java.util.*;

public class securityCode{
    static int[][] keypad={
    	{1, 2, 3},
    	{3, 4, 5},
    	{7, 8, 9}
    };
    public static boolean verify(String input, String code){
        if(input.length() != code.length())
        	return false;
        if(input.equals(code))
        	return true;
        int n= input.length();
        for(int i=0; i< n; ++i){
        	if(isValid(input.charAt(i), code.charAt(i)))
        		continue;
        	else
        		return false;
        }
        
        return true;
    }
    public static boolean isValid(char c1, char c2){
    	int n1= c1-'0', n2= c2-'0';
    	int x= (n2-1)/3, y= (n2-1)%3;
    	for(int i=0; i<3 ; ++i){
    		//horizontal
    		if(keypad[x][i]== n1)
    			return true;
    		// vertical
    		if(keypad[i][y]==n1)
    			return true;
    	}
    	return false;
    }
    
    public static void main(String[] args){
        
        System.out.println(verify("1434", "1478"));
        
    }
    
}
/*
Decimal Number
Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999. Only four decimal places are allowed. The output should be an irreducible fraction. 
E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
*/

import java.util.*;

public class decimalNumber{
    
    public static void reduce(double dicimal){
        int dividend=(int)(dicimal*10000), divisor=10000;
        int gcd= getGCD(dividend, divisor);
        System.out.println("result is: " + dividend/gcd + "/" + divisor/gcd);
        
    }
    
    // get the greatest common divisor
    public static int getGCD(int a, int b){
    	if( a==0 )
    		return b;

    	while( b >0 ){
    		int tmp=b;
    		b= a%b;
    		a=tmp;
    	}
    	return a;
    }

    public static void main(String[] args){
        reduce(0.35);
        reduce(0.24);
        reduce(0.9999);
        System.out.println();
        
    }
    
}
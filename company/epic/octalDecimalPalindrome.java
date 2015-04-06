/*
 Octal and Decimal Palindrome

The decimal and octal values of some numbers are both palindromes sometimes. Find such numbers within a given range.

*/

import java.util.*;

public class octalDecimalPalindrome{
    
    public static void find(int s, int e){

        while(s <=e){
        	String decimal= String.valueOf(s);
        	String octal= getOctal(s);
        	if(isPalindrome(decimal) && isPalindrome(octal))
        		System.out.println( decimal+" " + octal);
        	s++;
        }
        
    }
    public static String getOctal(int n){
    	/*String res="";
    	while(n>0){
    		int remainder= n%8;
    		n=n/8;
    		res+=remainder;
    	}
    	return res;// actually need the reversed res, but no matter in check palindrome*/

        // round 2
        String res="";
        while(n >0){
            res+= n%8;
            n= n/8;
        }
        return res;
    }
    public static boolean isPalindrome(String s){
    	int l=0, r= s.length()-1;
    	while(l<=r){
    		if(s.charAt(l)== s.charAt(r)){
    			l++;
    			r--;
    		}else
    			return false;
    	}
    	return true;
    }
    
    public static void main(String[] args){
        find(1, 1000);
        System.out.println();
        
    }
    
}
/*
Plus Equal Number
Given a number find whether the digits in the number can be used to form an equation with + and ‘=’. 
That is if the number is 123, we can have a equation of 1+2=3. But even the number 17512 also forms the equation 12+5=17.
*/

import java.util.*;

public class formEquation{
    
    public static void verify(int n){
    	String sn= String.valueOf(n);
        for(int i=1; i< sn.length(); ++i){
        	for(int j=i+1; j<sn.length(); ++j){
        		int a= Integer.parseInt(sn.substring(0, i));
        		int b= Integer.parseInt(sn.substring(i, j));
        		int c= Integer.parseInt(sn.substring(j, sn.length()));
        		if(isValid(a, b, c))
        			System.out.println(a+ " " + b+ " "+ c);
        	}
        }
        
    }
    // round2
    public static void verify2(int n){
        String sn= String.valueOf(n);
        for(int i=1; i< sn.length(); ++i){
            for(int j= i+1; j< sn.length(); ++j){
                int a= Integer.parseInt(sn.substring(0, i));
                int b= Integer.parseInt(sn.substring(i, j));
                int c= Integer.parseInt(sn.substring(j, sn.length()));
                if(isValid(a, b, c)){
                    System.out.println("valid");
                }
            }
        }
        
    }
    public static boolean isValid(int a, int b, int c){
    	if(a==b+c || b==a+c || c==a+b)
    		return true;
    	return false;
    }
    
    public static void main(String[] args){
        verify2(123);
        verify2(17512);
        //verify2(111);
        System.out.println();
        
    }
    
}
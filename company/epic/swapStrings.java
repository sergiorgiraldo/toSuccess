/*
 Swapping String
Given two strings, you need to transpose the first string to the second string by means of only swaps between 2 consecutive characters in the first string. This must be performed by doing a series of these swaps in order to get the second string.
*/

import java.util.*;

public class swapStrings{
    
    // similar to bubble sort
    public static void swap(String s1, String s2){
       	if(s1== s2) return;
       	int n= s1.length();
       	if(n!= s2.length()) return;
       	int i=0;
       	char[] s1chars= s1.toCharArray();
       	char[] s2chars= s2.toCharArray();

       	while(i < n){
       		if(s1chars[i] == s2chars[i])
       			i++;
       		else{
       			
       			for(int j=i; j<n-1; ++j){// swap consecutive chars
       				char tmp= s1chars[j];
       				s1chars[j]= s1chars[j+1];
       				s1chars[j+1]= tmp;
       			}     			
       		}
       	}
       	s1= new String(s1chars);
       	//System.out.println(s1);
        System.out.println(s1.equals(s2));
    }
    
    public static void main(String[] args){
        swap("abcd", "acbd");
        System.out.println();
        
    }
    
}
/*
Continuous Alphabets
Print continuous alphabets from a sequence of arbitrary alphabets . 
For example:
Input: abcdefljdflsjflmnopflsjflasjftuvwxyz
Output: abcdef; mnop; tuvwxyz
Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
Output: abcdef; mnop; tuvwxyz
*/

import java.util.*;

public class continuousAlphabets{
    
    public static void print(String input){
        String res="";
        int count=1;
        for(int i=1; i< input.length(); ++i){
        	char prev= Character.toLowerCase(input.charAt(i-1));
        	char cur= Character.toLowerCase(input.charAt(i));
        	if(cur==1+ prev){
        		res+= input.charAt(i-1);
        		count++;
        	}else{
        		if(count<=1)
        			continue;
        		else{
        			res+=input.charAt(i-1);
        			res+=";";
        			count=1;
        		}
        	}
        }

        char last=Character.toLowerCase(input.charAt(input.length()-1));
        char prev=Character.toLowerCase(input.charAt(input.length()-2));
        if(last==prev+1)
        	res+=input.charAt(input.length()-1);
        else{
        	if(res.length() > 0)
        		res= res.substring(0, res.length()-1);
        }
        System.out.println(res);
    }
    
    public static void main(String[] args){
        print("abcdefljdflsjflmnopflsjflasjftuvwxyz");
        print("AbcDefljdflsjflmnopflsjflasjftuvWxYz ");
        System.out.println();
        
    }
    
}
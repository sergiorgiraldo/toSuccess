/*
 Separate the number
Print the sequences from the input given by the user separated by semicolon
e.g.: 4678912356012356
output: 4;6789;123;56;0123;56;(subsequence in alphabetical order)

*/

import java.util.*;

public class separateNumbers{
    
    //4678912356012356
    public static void separate(String input){
        int n= input.length();
        if(n<=1) return ;

        String res="";
        int count=1;
        for(int i=1; i<n; ++i){
        	if(input.charAt(i)== input.charAt(i-1) +1 ){
        		res+= input.charAt(i-1);
        		count++;
        	}else{
        		if(count<=1)
        			continue;
        		else{
        			res+=input.charAt(i-1) +";";
        			count=1;
        		}
        	}
        }
        if(input.charAt(n-2)+1 ==input.charAt(n-1) ){
        	res+= input.charAt(n-1);	
        }else{
        	if(res.length() > 0)
        	res= res.substring(0, res.length()-1);
        }
        

        
        	


        System.out.println(res);
        
    }
    
    public static void main(String[] args){
        separate("4678912356012334");
        separate("4678912356012345");
        separate("467891235601235");
        System.out.println();
        
    }
    
}
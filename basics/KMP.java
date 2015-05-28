/*search a substring*/

import java.util.*;

//http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
public class KMP{
    
    public static boolean kmpsearch(String pattern, String text){
         int[] table= getPartialMatchTable(pattern);
         for(int i=0; i< text.length(); ){
         	int j=i;
         	for(; j< pattern.length(); ++j){
         		if(pattern.charAt(j)== text.charAt(j+i)){
         			j++;
         			if(j==pattern.length())
         				return true;
         		}else{
         			break;
         		}
         		int next= j- table[i];
         		i+=next;
         	}
         }
         return false;
         System.out.println();
    }
    
    // some problems here 
    public static int[] getPartialMatchTable(String pattern){
    	int len= pattern.length();
    	int[] table= new int[len];
    	if(len<=1)
    		return table;
    	int pos=1;// 0 does not matter
    	while(pos < len ){
    		String sub= pattern.substring(0, pos+1);// at least of len 2
    		int i= 0;
    		int count=0;
    		while(i < sub.length()-1){
    			if(sub.charAt(i)==sub.charAt(sub.length()-i-2)){
    				count++;
    			}
    			i++;
    		}
    		table[pos]=count;
    	}
    	return table;
    }
    public static void main(String[] args){
        
        boolean kmpsearch("ABCDABD", "BBC ABCDAB ABCDABCDABDE");
 
    }
    
}
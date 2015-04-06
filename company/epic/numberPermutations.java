package ll;
/*
Length is given as input.Print all possible permutations of numbers between 0-9. 
Eg: if input length=4 
all possible combinations can be 0123, 1234, 5678,9864,...etc all combinations of length from in all numbers between 0-9

*/
import java.util.*;

public class numberPermutations{
    
    public static void generate(int len){
        	ArrayList<String> res= new ArrayList<String>();
        	helper(res, "", len);
        	System.out.println(res.toString());
    }
    public static void helper(ArrayList<String> res, String path , int len){
    	if(len==0){
    		res.add(new String(path));
    		return;
    	}
    	for(int i=0; i<= 9; ++i){
    		helper(res, path+i, len-1);
    	}
    
    }
    public static void main(String[] args){
        generate(4);
        System.out.println();
        
    }
    
}
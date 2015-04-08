/*
compute all permutations of a string
*/


import java.util.*;

public class stringPermutation{
    
     public static void generate(String s){
	        ArrayList<String> res= new ArrayList<String>();
	        helper(res, "", 0, s);
	        System.out.println(res.size());
	        System.out.println(getFactorial(s.length()));
	     }
	     public static void helper(ArrayList<String> res, String path, int pos, String input){
	     		if(pos== input.length()){
	     			res.add(new String(path));
	     			return;
	     		}
	     		for(int i=pos; i< input.length(); ++i){
	     			char c= input.charAt(i);
	     			path+=c;
	     			helper(res, path, pos+1, input);
	     			path=path.substring(0, path.length()-1);// try next char
	     		}

	     }

	    public static int getFactorial(int n){
	    	int res=1;
	    	for(int i=1; i<=n; ++i)
	    		res=res*i;
	    	return res;
	    }
	    public static void main(String[] args){
	        
	        generate("whatever");
	 
	    }
    
}
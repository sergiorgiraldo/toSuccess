/*
implement an algorithm to print all valid comibnations(well-closed) of n-pairs parentheses
*/

import java.util.*;

public class parentheseCombination{
     // build n from n-1
     public static void generate(int n){
        ArrayList<String> res= new ArrayList<String>();
        res.add("()");
        if(n==1) return;
        for(int i=1; i< n; ++i){
        	HashSet<String> visited= new  HashSet<String>();
        	ArrayList<String> prevSet= new ArrayList<String>(res);
        	for(String s: prevSet){
        		visited.add("("+s+")");
        		int len= s.length();
        		for(int j=0; j< len; ++j){
        			StringBuilder prev= new StringBuilder(s);
        			prev.insert(j, "()");
        			if(!visited.contains(prev.toString()))
        				visited.add(prev.toString());
        		}
        	}
        	res.clear();
        	res.addAll(visited);
        }
        System.out.println(res);
   }
   // build by recursion, seems like more efficient 
   // use count for left and right respectively, great help
   public static void dfs(char[]path, int lcont, int rcont, int n){
        if(lcont> n || rcont > lcont)
            return;
        if(lcont + rcont==2*n){
            System.out.println(path);
            return;
        }
        if(lcont < n){// more left cont remaing
            path[lcont+rcont]= '('; // can not use StringBuilder, hard to reverse back 
            dfs(path, lcont+1, rcont, n);
        }

       if(rcont < n){
           path[lcont+rcont]= ')';
            dfs(path, lcont, rcont+1, n);
       }

   }

    public static void main(String[] args){
        
        //generate(3);
        dfs(new char[6], 0, 0, 3);
    }
    
}
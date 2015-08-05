/* Write a method to return all subsets of a set */

import java.util.*;

public class subsets{
    
     public static void generate(int[] set){
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int i=0; i< set.length; ++i){
        	ArrayList<ArrayList<Integer>> prev= new ArrayList<ArrayList<Integer>>(res);
        	for(int j=0; j< prev.size(); ++j){
        		ArrayList<Integer> a= new ArrayList<Integer> ( prev.get(j));
        		a.add(set[i]);
        		res.add(a);
        	}
        }
         System.out.println(res);
    }

    
    public static void main(String[] args){
        
        generate("whatthehell!");
 
    }
    
}
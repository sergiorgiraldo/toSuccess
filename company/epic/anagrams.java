
/*
 Enumerate all possible anagrams of a random string 
 where capital letters, numbers, and symbols are not allowed to move within the string.
 * */
import java.util.*;
public class anagrams{
	
    public static void generate(String s){
    	ArrayList<Character> chars= new ArrayList<Character>();
        for(int i=0; i< s.length(); ++i){
        	char c= s.charAt(i);
        	if(Character.isUpperCase(c) || Character.isDigit(c) || !Character.isAlphabetic(c))
        		continue;
        	else
        		chars.add(c);
        }
        Character[] input= new Character[chars.size()];
        input= chars.toArray(input);
        int[] visited= new int[input.length];
            
        ArrayList<ArrayList<Character>> permutes= new  ArrayList<ArrayList<Character>>();
        dfs2(permutes, new ArrayList<Character>(), visited, input);
        
        for(ArrayList<Character> one: permutes){
        	for(int i=0; i< s.length(); ++i){
        		char c= s.charAt(i);
            	if(Character.isUpperCase(c) || Character.isDigit(c) || !Character.isAlphabetic(c))
            		one.add(i, c);
        	}
        }
        
        for(ArrayList<Character> one: permutes){
        	String res="";
        	for(int i=0; i<one.size(); ++i)
        		res+=one.get(i);
        	System.out.println(res);
        }
        	
    }
    public static void dfs( ArrayList<ArrayList<Character>> res, ArrayList<Character> path, int[] visited, Character[] input ){
    	if(path.size()== input.length){
    		res.add(new ArrayList<Character>(path));
    		return;
    	}
    	for(int i=0; i< input.length; ++i){
    		char c= input[i];
    		if(visited[i]==1){
    			continue;
    		}
    		visited[i]=1;
    		path.add(c);
    		dfs(res, path, visited, input);
    		path.remove(path.size()-1);
    		visited[i]=0;
    	}
    }

    // round2
    public static void dfs2(ArrayList<ArrayList<Character>> res, ArrayList<Character> path , int[] visited, Character[] input){
        if(path.size()==input.length){
            res.add(new ArrayList<Character>(path));
            return;
        }
        for(int i=0; i<input.length; ++i){
            if(visited[i]==1) continue;
            path.add(input[i]);
            visited[i]=1;
            dfs2(res, path,  visited, input);
            path.remove(path.size()-1);
            visited[i]=0;
        }
    }
    
    public static void main(String[] args){
        generate("1ab4cA%d");
        System.out.println();
        
    }
    
}
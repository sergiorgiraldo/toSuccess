package ll;
/*
 
给一个值表A-1 B-13 C-110 。。。
然后计算给定串的值， 右边串有大于当前的就算负数，大于就算正数
eg  CBA 110+13+1 = 124
     ABC -1-13+110=96
 * */
import java.util.*;

public class reversePlus{
    static HashMap<Character, Integer> dict= new  HashMap<Character, Integer> ();
    public static void helper(String s){
    	int res=0;
        for(int i=0; i<s.length()-1; ++i){
        	if(s.charAt(i) < s.charAt(i+1)){
        		res-=dict.get(s.charAt(i));
        	}else{
        		res+=dict.get(s.charAt(i));
        	}
        }
        res+=dict.get(s.charAt(s.length()-1));
        System.out.println(res);
    }
    
    public static void main(String[] args){
        dict.put('A', 1);
        dict.put('B', 13);
        dict.put('C', 110);
        helper("ABC");
        helper("CBA");
        System.out.println();
        
    }
    
}
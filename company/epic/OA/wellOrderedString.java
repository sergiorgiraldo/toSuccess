/*
(1)   A number is called ‘desirable’ if all the digits are strictly ascending eg: 159 as 1<5<9. You know that your rival has a strictly numeric password that is 'desirable'. Your close ally has given you the number of digits (N) in your rival's password. WAP that takes in 'N' as input and prints out all possible 'desirable' numbers that can be formed with N digits.

(2)  You know a password is well-ordered string. Well-ordered string means that the order of the characters is in an alphabetical increasing order. Like “abEm” is a well-ordered string. However, “abmE” is not a well-order string. 
 */

import java.util.*;

public class wellOrderedString{
    
    // n <10
    // recursion,
    //static String dict="0123456789aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    public static ArrayList<String> generate(int n){
        
        ArrayList<String> res = new ArrayList<String> ();
        if(n<=0) return res;
        helper( res, new String(), n);
        return res;
        
    }
    public static void helper(ArrayList<String> res, String path, int n){
        if(path.length()==n){
            res.add(new String(path));
            return;
        }
        for(char c='a'; c<='z'; ++c){
            if(isValid(path, c)){
                path+=c;
                helper(res, path, n);
                path=path.substring(0, path.length()-1);
            }
        }
    }
    public static boolean isValid(String s, char c){
        if(s.length()==0) return true;
        if(s.charAt(s.length()-1) < c)
            return true;
        else
            return false;
    }
    
    public static void main(String[] args){
        
        System.out.println(generate(3).toString());
        
    }
    
}

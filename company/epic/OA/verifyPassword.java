/*
15. Verify Password
Verify if the given password is valid/invalid
1. must be 5-12 characters long . 
2. must contain at least one number and one lowercase character
3. a sequence must not be followed by the same sequence (like 123123qs is invalid, 123qs123 is valid)
*/
import java.util.*;

public class verifyPassword{
    
    public static boolean check(String input){
        int n= input.length();
        if(n>12 || n<5) return false;
        boolean haslowercase=false, hasnumber=false;
        for(int i=0; i< n; ++i){
            char c= input.charAt(i);
            if(Character.isLowerCase(c))
               haslowercase=true;
            if(Character.isDigit(c))
               hasnumber=true;
        }
        if(!haslowercase || !hasnumber)
               return false;
        // check same sequence, O(n^2)
        // invalid sequence is adjacent
        for(int len=1; len<= n/2; ++len){
            HashSet<String> set= new HashSet<String>();
            for(int i=0; i+len<= n; i+=len){
                String sub= input.substring(i, i+len);
                if(set.contains(sub)){
                    if(i>=len && input.charAt(i)==input.charAt(i-len))// invalid is adjacent
                    return false;
                }
                else
                    set.add(sub);
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        
        System.out.println(check("123123qs"));
        System.out.println(check("123qs123"));
        System.out.println(check("123qss123"));
    }
    
}
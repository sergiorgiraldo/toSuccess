/*
 
 Print all valid phone numbers of length n subject to following constraints:
 If a number contains a 4, it should start with 4
 No two consecutive digits can be same
 Three digits (e.g. 7,2,9) will be entirely dis allowed

 */
import java.util.*;

public class telephoneNo{
    
    public static ArrayList<String> generate(int n){
        
        ArrayList<String> res = new ArrayList<String> ();
        if(n<=0) return res;
        helper( res, new String(), n);
        return res;
        
    }
    public static void helper(ArrayList<String> res, String path, int n){
        if(path.length()==n){
            char[] pathchars= path.toCharArray();
            for(int i=0; i<n; ++i){
                if(pathchars[i]=='4'){
                    char tmp= pathchars[0];
                    pathchars[0]='4';
                    pathchars[i]=tmp;
                    break;
                }
            }
            path=String.valueOf(pathchars);
            res.add(path);
            return;
        }
        for(char c='0'; c<='9'; ++c){
            if(c=='7' || c=='2' || c=='9') continue;
            if(path.length()!=0 && path.charAt(path.length()-1)==c)
                continue;
            else{
                path+=c;
                helper(res, path, n);
                path=path.substring(0, path.length()-1);
                continue;
            }
        }
    }
    
    
    public static void main(String[] args){
        
        System.out.println(generate(2).toString());
        
    }
    
}

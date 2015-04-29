import java.util.*;

public class wellOrderedPWD{

    // n <10
    // recursion,
    public static ArrayList<String> generate(int n){
        
        ArrayList<String> res = new ArrayList<String> ();
        if(n<=0) return res;
        helper( res, new StringBuilder(), 0, n);
        return res;
    
    }
    public static void helper(ArrayList<String> res, StringBuilder path, int pos, int n){
        if(pos==n){
            String p= path.toString();
            res.add(new String(p));
            return;
        }
        
        for(int i=0; i<=9; ++i){
            path.append(i);
            if(isValid(path.toString())){
                helper(res, path, pos+1, n);
            }else
                path.setLength(path.length()-1);
        }
    
    }
    public static boolean isValid(String s){
        char[] schars= s.toCharArray();
        if(schars.length==1) return true;
        for(int i=1; i<schars.length; ++i){
            if(schars[i] < schars[i-1])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    
        System.out.println(generate(1).toString());
    
    }

}

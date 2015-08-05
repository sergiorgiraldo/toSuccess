/*
 You are given a telephone keyboard
 0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separater
 if you type "2", you will get 'A', that is "2"-'A', "22"-'B' ,"222"-'C', "2222"-'2'
 However, the digits can repeated many times
 "22222"-you get 'A' again . 
 You can use "#" to separate characters, for example
 "2#22", you get "AB"
 However, you may also have consecutive different digits without separator:"23"-'AD'.
 If you type "*", it means space..
 You a given a sequence of digits, translate it into a text message
 */
import java.util.*;

public class SMS{
    static String[] dict= {"0", "1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6","PQRS7", "TUV8", "WXYZ9"};
    public static String translate(String s){
        //ArrayList<String>  res= new ArrayList<String> ();
        //if(s.length() <=0) return res;
        String res= helper2( new String(), s);
        return res;
    }
    public static void helper(ArrayList<String> res, String path, String s)
    {
    	if(s.length()==0){
    		res.add(new String(path));
    		return;
    	}
    	if(s.charAt(0)=='*'){
    		path+=" ";
    		helper(res, path, s.substring(1));
    	}else if(s.charAt(0)=='#'){
    		helper(res, path, s.substring(1));
    	}else{
            // 2222
            int count=0;
            int numberindex=s.charAt(0) - '0';
            while(count<s.length() && s.charAt(count)==s.charAt(0)){
                count++;
            }
            // count=4
            int charindex=(count-1)% (dict[numberindex].length());
            path+=dict[numberindex].charAt(charindex);
            s=s.substring(count);
            helper(res, path, s);
    	}
    }
    // round2
   // dict= {"0", "1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6","PQRS7", "TUV8", "WXYZ9"};
    public static String helper2(String path, String s){
        if(s.length()==0)
            return path;
        char c= s.charAt(0);
        if(c=='*'){
            path+=" ";
            return helper2(path, s.substring(1));
        }else if(c=='#'){
            return helper2(path, s.substring(1));
        }else{
            int count=0;
            int dictIndex= c-'0';
            while(count < s.length() && s.charAt(count)== c)
                count++;
            int charIndex= (count-1)%dict[dictIndex].length();
            path+= dict[dictIndex].charAt(charIndex);
            return helper2(path, s.substring(count));
        }

    }
    public static void main(String[] args){
        System.out.println(translate("2***#22299#999"));
        
    }
    
}
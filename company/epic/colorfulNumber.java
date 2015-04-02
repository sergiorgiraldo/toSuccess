import java.util.*;

public class colorfulNumber{

    public static boolean isCN(int n){
        String sn= String.valueOf(n);
        HashSet<String> parts = new HashSet<String>();
        for(int len=1; len< sn.length(); ++len){
            for(int i=0; i+len <= sn.length(); ++i){
                String cur= sn.substring(i, i+len);
                if(!parts.contains(cur))
                    parts.add(cur);
            }
        }
        //System.out.println(parts.toString());
        HashSet<Integer> check= new HashSet<Integer>();
        for(String cur: parts){
            int res=1;
            for(int i=0; i< cur.length(); ++i){
                res*=cur.charAt(i)-'0';
            }
            if(check.contains(res))
                return false;
            else
                check.add(res);
            //System.out.println(cur + check.toString());
        }
        
        return true;
    }
    
    public static void main(String[] args){
        System.out.println(isCN(3245));
        System.out.println(isCN(326));
    
    }

}

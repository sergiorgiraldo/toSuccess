/*
 A number can be broken into different sub-sequence parts. Suppose a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
 And this number is a colorful number, since product of every digit of a sub-sequence are different. 
 That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. But 326 is not a colorful number as it 
 generates 3 2 6 (3*2)=6 (2*6)=12. You have to write a function that tells if the given number is a colorful number or not.
 */
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
    
    // round2
    public static boolean isCN2(int n){
        String sn= String.valueOf(n);
        HashSet<String> divides= new HashSet<String>();
        for(int i=0; i< sn.length(); ++i){
            for(int j=i; j< sn.length(); ++j){
                String sub= sn.substring(i, j+1);
                if(divides.contains(sub))
                    continue;
                else
                    divides.add(sub);
            }
        }
        divides.remove(sn);
        HashSet<Integer> values= new HashSet<Integer>();
        for(String sub: divides){
            int v=1;
            for(int i=0; i< sub.length(); ++i){
                v*= sub.charAt(i) - '0';// remember to deduct '0'
            }
            if(values.contains(v))
                return false;
            else
                values.add(v);
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(isCN2(3245));
        System.out.println(isCN2(326));
    
    }

}

/*The stepping number:
 A number is called as a stepping number if the adjacent digits are having a difference of 1. For eg. 8,343,545 are stepping numbers. While 890, 098 are not. The difference between a ‘9’ and ‘0’ should not be considered as 1. Given start number(s) and an end number (e) your function should list out all the stepping numbers in the range including both the numbers s & e.
 
 s and e are the range, support non-negative numbers only
*/

import java.util.*;

public class steppingNumber{
    
    public static ArrayList<Integer> generate(int s, int e){
        ArrayList<Integer> res= new ArrayList<Integer>();
        if(e<=s)
            return res;
        while(s <=e){
            if(isSteppingNumber(s, s, e)){
                res.add(s);
            }
            s++;
        }
        return res;
    }
    
    public static boolean isSteppingNumber(int num, int s, int e){
        if(num< s || num > e ){
            return false;
        }
        String snum= String.valueOf(num);
        if(snum.length()==1) return true;
        for(int i=1; i<snum.length(); ++i){
            int last= snum.charAt(i-1)- '0';
            int cur= snum.charAt(i) - '0';
            if(Math.abs(cur- last)!=1)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        
        System.out.println(generate(0,100).toString());
        
    }
    
}
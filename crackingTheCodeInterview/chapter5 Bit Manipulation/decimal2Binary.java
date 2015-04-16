/*
Given a (decimal - e g 3 72) number that is passed in as a string, print the binary rep- resentation If the number can not be represented accurately in binary, print “ERROR”
*/

import java.util.*;

public class decimal2Binary{
    
     public static void convert(double decimal){
         StringBuilder res= new StringBuilder();
         res.append(".");
         
         while(decimal >0){
            if(res.length() >33){
                System.out.println("ERROR");
                break;
            }
            
            if(decimal==1){
                res.append(1);
                break;
            }
            
            decimal*=2;
            if(decimal >=1){
                res.append(1);
                decimal-=1;
            }else{
                res.append(0);
            }
         }
         System.out.println(res.toString());
    }
    
    public static void main(String[] args){
        
        convert(0.125);
 
    }
    
}
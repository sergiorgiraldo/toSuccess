/*
Count And Say
First,let user input a number, say 1. Then, the function will generate the next 10 numbers which satisfy this condition:
1, 11,21,1211,111221,312211...
explanation: first number 1, second number is one 1, so 11. Third number is two1(previous number), so 21. next number one 2 one 1, so 1211 and so on...

*/
import java.util.*;

public class countAndSay{
    
    public static void generate(int n){
        String old = String.valueOf(n);
        
        int itr=0;
        while(itr <10){
            System.out.println(old);
            StringBuilder cur= new StringBuilder();
            for(int i=0; i< old.length();){
                int count=0;
                char value= old.charAt(i);
                while(i < old.length() && old.charAt(i)==value){
                    count++;
                    i++;
                }
                cur.append(count);
                cur.append(value);
            }
            old= cur.toString();
            itr++;
        }
    }

    // round2
    public static void generate2(int n){
        int itr=0;
        String old= String.valueOf(n);
        while(itr <10){        
            System.out.println(old);
            StringBuilder cur= new StringBuilder();           
            for(int i=0; i < old.length();){
                int count=0;
                char value= old.charAt(i);
                while(i< old.length() && old.charAt(i)==value){
                    count++;
                    i++;
                }
                cur.append(count);
                cur.append(value);
            }

            old= cur.toString();
            itr++;
        }
    }
    public static void main(String[] args){
        generate2(2);
        System.out.println();
        
    }
    
}
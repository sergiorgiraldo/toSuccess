package ll;
/*Mutiplicative iteration.Assume letters are A=1,B=2....
 * The number N=4 then A=1*4=4.
 * If result is greater than 26 mod 26.Input a string and give a encrypted result as output.
 * */
import java.util.*;

public class encrypt{
    // 'A' : 65
    public static void generate(String text, int n){
    	String res="";
    	text= text.toUpperCase();
		for(int i=0; i< text.length(); ++i){
        	int tmp= ((text.charAt(i)- 64)*n )% 26;
			res+=tmp;
        }
        System.out.println(res);
    }
    
    public static void main(String[] args){
        generate("aaabbbccc", 4);
        System.out.println();
        
    }
    
}
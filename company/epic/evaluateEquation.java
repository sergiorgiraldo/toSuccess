package ll;

import java.util.*;
/*given an expression like 3*4 + 18-9 (only +, - , * operators) as a string evaluate it strictly from left to right
 */
public class evaluateEquation{
    
    public static void evaluate(String s){
    	 Stack<Character> ops = new Stack<Character>(); 
    	 Stack<Integer> nums= new Stack<Integer>();

    	 String sub="";
    	 for(int i= s.length()-1; i>=0; --i){
    		 if(s.charAt(i)=='+' ||s.charAt(i)=='-' || s.charAt(i)=='*' ){
    			 ops.push(s.charAt(i));
    			 //String sub= s.substring(i+1, numend+1);
    			 nums.push(Integer.parseInt(sub)); 
    			 sub="";
    		 }
    		 else{
    			 sub=s.charAt(i) + sub;
    		 }
    	 }
    	 nums.push(Integer.parseInt(sub));
    	 
    	 int res=0;
    	 while(!ops.isEmpty()){
    		 char op= ops.pop();
    		 if(nums.size()<2)
    			 return;
    		 int n1= nums.pop();
    		 int n2= nums.pop();
    		 int tmp=0;
    		 switch(op){
    			 case '+': tmp= n1+n2; break;
    			 case '-': tmp= n1-n2; break;
    			 case '*': tmp= n1*n2; break;
    		 }
    		 nums.push(tmp);
    		 res= tmp;
    	 }
    	 System.out.println(res);
    }
    public static void main(String[] args){
        evaluate("11+1*1-5");
        evaluate("111+1*10-5+0");
        System.out.println();
        
    }
    
}
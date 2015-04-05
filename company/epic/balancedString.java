/*
Balanced String
Given a string that has{},[],() and characters. Check if the string is balanced. 
E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
*/

import java.util.*;

public class balancedString{
    
    public static boolean isBalanced(String s){
        Stack<Character> stack= new Stack<Character>();

        for(int i=0; i< s.length(); ++i){
        	char c= s.charAt(i);
        	if(c=='{' || c=='[' || c=='(')
        		stack.push(c);
        	else if(c=='}'){
        		if(!stack.isEmpty() && stack.peek()=='{'){
        			stack.pop();
        		}
        		else 
        			return false;
        	}
        	else if(c==']'){
        		if(!stack.isEmpty() && stack.peek()=='['){
        			stack.pop();
        		}
        		else 
        			return false;
        	}else if(c==')'){
        		if(!stack.isEmpty() && stack.peek()=='('){
        			stack.pop();
        		}
        		else 
        			return false;
        	}else{

        	}
        		
        }

        return stack.isEmpty();   
    }
    
    public static void main(String[] args){
        
        //isBalanced("");
        
        System.out.println(isBalanced("{a[(b)]}"));
        System.out.println(isBalanced("{a[(b])}"));
        
    }
    
}
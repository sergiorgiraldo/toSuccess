package ll;
/*
 Replace Words
Given a string. Replace the words whose length>=4 and is even, with a space between the two equal halves of the word. Consider 
only alphabets for finding the evenness of the word
I/P “A person can’t walk in this street”
O/P “A per son ca n’t wa lk in th is str eet”
*/
import java.util.*;

public class replaceWord{
    
    public static void replace(String s){
    	
        String[] ssplit= s.split(" ");
        if(ssplit.length==0)
        	return;
        String res="";
        for(int i=0; i<ssplit.length; ++i){
        	String tmp=ssplit[i].replaceAll("[^a-zA-Z0-9]","");
        	int len= tmp.length();
        	if(len==0 ) continue;
        	if(len%2!=0 || len<4)
        		res+=ssplit[i]+" ";
        	else{
        		String left= ssplit[i].substring(0, len/2);
        		String right=ssplit[i].substring(len/2);
        		res+= left+" "+right + " ";
        	}
        }
        if(res.length() >0)
        	res=res.substring(0, res.length()-1);
        System.out.println(res);
    }
    
    public static void main(String[] args){
        replace("");
        replace("A person, can’t walk. in this street?");
        System.out.println();
        
    }
    
}
/*
Given a string. Replace the words whose length>=4 and is even, with a space between the two equal halves of the word. Consideronly alphabets for finding the evenness of the word
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
    
    // round2
    public static void replace2(String s){
        String[] ssplit= s.split(" ");
        String res="";
        for(int i=0; i< ssplit.length; ++i){
            String cur= ssplit[i];
            if(cur.length()==0) continue;
            cur= cur.replaceAll("[^0-9a-zA-Z]", "");
            if(cur.length() >=4 && cur.length()%2==0){
                res+= ssplit[i].substring(0, cur.length()/2);
                res+=" ";
                res+= ssplit[i].substring(cur.length() /2)+ " ";
            }else
                res+= ssplit[i]+ " ";
        }
        if(res.length() > 0)
            res= res.substring(0, res.length()-1);
        System.out.println(res);

    }

    public static void main(String[] args){
        replace2("");
        replace2("A person, can't walk, in the street?");
        System.out.println();
        
    }
    
}
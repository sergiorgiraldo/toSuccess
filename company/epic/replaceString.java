package ll;
/* Replace String
From a given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'.
Example Input: " A boy is playing in a garden"
Example Output: " ONE boy is playing in one garden"
-- Not that 'A' and 'a' are to be replaced only when they are single characters, not as part of another word.
*/
import java.util.*;

public class replaceString{
    
    public static void replace(String s){
    	String[] ssplit= s.split(" ");
    	if(ssplit.length==0)
    		return;
    	
    	String res="";
    	for(int i=0; i<ssplit.length; ++i){
    		if(ssplit[i].equals("a"))
    			ssplit[i]="one";
    		else if(ssplit[i].equals("A"))
    			ssplit[i]="ONE";
    		if(ssplit[i].length()>0)
    			res+=ssplit[i]+" ";
    	}
        res= res.substring(0, res.length()-1);
        System.out.println(res);
    }
    
    public static void main(String[] args){
        replace("a");
        replace(" A boy is playing in a garden");
        System.out.println();
        
    }
    
}
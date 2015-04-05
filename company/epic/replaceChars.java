package ll;
/*Replace AEIOU
Replace a,e,i,o,u with A,E,I,O,U.
At most four eligible letters from the rear of the string are replaced.
The first three eligible letters in the string are always exempted from replacement.
*/
import java.util.*;

public class replaceChars{
    
    public static void replace(String s){
        int replacecount=0, eligiblecount=0;
        char [] schars= s.toCharArray();
        for(int i=0; i< schars.length; ++i){
        	char c= schars[i];
        	if(c=='a' || c=='e' || c=='i' ||c=='o' || c=='u'){
        		if(eligiblecount<3)
        			eligiblecount++;
        		else if(replacecount < 4){
        			replacecount++;
        			schars[i]= Character.toUpperCase(c);
        		}	
        	}
        }
        String res= new String(schars);
        System.out.println(res);
    }
    
    public static void main(String[] args){
        replace("aeiou+aeiou");
        replace("");
        System.out.println();
        
    }
    
}
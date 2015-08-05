package ll;
/*If jan 1 2011 is saturday,
 for march 6 2064 , which day .
 */
import java.util.*;

public class determineDate{
    
    public static void find(){
        String[] week ={"SUN","MON", "TUE", "WEN", "THUR", "FRI", "SAT"};
    	int gap= 365*(2064- 2011) + 31+ 28 +5 +(2064-2011)/4 +1;
    	int offset= gap%7;
    	System.out.println(week[(6+offset)%7]);
        
    }
    
    public static void main(String[] args){
        find();
        System.out.println();
        
    }
    
}
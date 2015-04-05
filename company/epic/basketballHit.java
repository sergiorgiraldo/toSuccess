package ll;
/* Basketball Hit Rate
The hit rate of the basketball game is given by the number of hits divided by the number of chances. 
For example, you have 73 chances but hit 15 times, then your hit rate is 15/73=0.205 (keep the last3 digits).
 On average, you have 4.5 chances in each basketball game. Assume the total number of games is 162. 
 Write a function for a basketball player. He will input the number
of hits he has made, the number of chances he had, and the number of remaining games. 
The function should return the number of future hits, so that he can refresh his hit rate to 0.45
*/
import java.util.*;

public class basketballHit{
    // (hits+ futurehits)/allchances=0.45
	// allchances= chances + 4.5* remaining
    public static int predict(int hits, int chances, int remain){
        int futurehits=0;
        futurehits= (int)(0.45*(chances + remain*4.5)- hits);
        
        return futurehits;
    }
    
    public static void main(String[] args){
        
        System.out.println(predict(12, 73, 89));
        
    }
    
}
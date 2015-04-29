
/*
Bull and Cows Game
There’s a word guessing game. One person think a word, and the other one guess a word,  both words have the same length.
The person should return the number of bulls and cows for the guessing. Bulls represent the number of same characters in the same spots,
 whereas cows represent the number of characters guessed right but in the wrong spots. Write a program with two input strings, 
 return the number of bulls and cows.
*/
import java.util.*;

public class bullsAndCows{
    // this program does not care about number of char appeared ?
    public static void generate(String think, String guess){
    	
    	int bulls=0, cows=0;
    	if(think.equals(guess)){
    		bulls=think.length(); // right, same place
    		cows=0; // right, wrong place
    	}
    	int mask=0;
    	
    	for(int i=0; i< think.length(); ++i){
    		mask|=1<<(think.charAt(i)-'a');
    	}
        for(int i=0; i< Math.min(think.length(), guess.length()); ++i){
        	if(think.charAt(i)== guess.charAt(i))
        		bulls++;
        	if((mask & (1<<(guess.charAt(i)-'a')))!=0){
        		cows++;
        	}
        }
        cows= cows- bulls;
        System.out.println("bulls: " + bulls + " cows: "+ cows);
    }

    // round2
    public static void generate2( String e, String s){
        if(s.length() != e.length())
            return;
        int bulls=0, cows=0;
        for(int i=0; i< s.length(); ++i){
            if(s.charAt(i)== e.charAt(i))
                bulls++;
        }

        int mask=0;
        for(int i=0; i<e.length(); ++i){
            mask|= (1 << (e.charAt(i)- 'a'));
        }
        for(int i=0; i< s.length(); ++i){
            if(mask &(1<<(s.charAt(i)- 'a')))
                cows++;
        }
        cows-= bulls;
        System.out.println("bulls: " + bulls + " cows: "+ cows);
    }
    
    public static void main(String[] args){
        generate2("picture", "epic");
        generate2("forum", "four");// 2 2
        generate2("forum", "forur");// 2 2
        System.out.println();
        
    }
    
}
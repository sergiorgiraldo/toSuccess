/*
RGBCompare
Given a string of RGB value (rr, gg, bb)which represents in hexadecimal. Compare if rr or gg or bb is the biggest, or two of those values are equal and larger than the third one, or three values are equal with each other.
*/

import java.util.*;

public class compareRGB{
    
    public static void compare(String s){
        int rr= Integer.decode("0x" + s.substring(0, 2));
        int gg= Integer.decode("0x" + s.substring(2, 4));
        int bb= Integer.decode("0x" + s.substring(4, 6));

        if( rr ==gg && gg==bb)
        	System.out.println("rr = gg = bb");
        
        if(rr >=gg && rr >= bb){
        	if( gg >= bb)
        		System.out.println("rr >= gg >= bb");
        	else
        		System.out.println("rr >= bb > gg");
        }

        if(gg >=rr && gg >= bb){
        	if( rr >= bb)
        		System.out.println("gg >= rr >= bb");
        	else
        		System.out.println("gg >= bb > rr");
        }

        if(bb >=gg && bb >= rr){
        	if( gg >= rr)
        		System.out.println("bb >= gg >= rr");
        	else
        		System.out.println("bb >= rr > gg");
        }

    }
    
    public static void main(String[] args){
        compare("FF2BFF");
        System.out.println();
        
    }
    
}
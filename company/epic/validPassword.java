/*
Valid Password
In 1-9 keypad one key is not working. If someone enters a password then not working key will not be entered. You have given expected password and entered password. Check that entered password is valid or not. Ex: entered 164, expected 18684 (you need to take care as when u enter18684 and 164 only both will be taken as 164 input)
*/
import java.util.*;

public class validPassword{
    
    public static boolean isValid(String entered, String expected){
        char broken='#';
        int i=0, j=0;
        for(; i< expected.length(); ){
            if(j==entered.length())// entered and expected must end at the same time
                break;
            else if(entered.charAt(j) != expected.charAt(i) && broken=='#'){ // broken not set
                broken= expected.charAt(i);
                i++;
            }else if(entered.charAt(j) != expected.charAt(i) && broken==expected.charAt(i)){ // broken set and expected = broken
                    i++;
            }else if(entered.charAt(j) != expected.charAt(i) && broken!=expected.charAt(i)){ // broken set but expected !=broken
                return false;
            }else{
                // same
                i++;
                j++;
            }
        }
        while(i < expected.length() && expected.charAt(i)==broken)
            i++;
        return i==expected.length();
    }
    // round 2
    public static boolean isValid2(String entered, String expected){
        int i=0, j=0;
        char broken= '#';
        while(j< entered.length()){
            if( entered.charAt(j) != expected.charAt(i) && broken=='#'){
                broken= expected.charAt(i);
                i++;
            }else if(entered.charAt(j) != expected.charAt(i) && broken!=expected.charAt(i)){
                return false;
            }else if(entered.charAt(j) != expected.charAt(i) && broken==expected.charAt(i)){
                i++;
            }else{
                i++;
                j++;
            }
        }
        while(i < expected.length() && expected.charAt(i)== broken)
            i++;
        return i== expected.length();
    }
    
    public static void main(String[] args){
        
        System.out.println(isValid2("164", "1868884888"));
        
    }
    
}
package ll;
/*
given a horizontal array of strings convert it to vertical. like english characters are read left to right. 
convert them to a chinese format which is read vertically. 
eg. 
epic is a healthcare company. 
interviewing for software developer. 
print this vertically sentence by sentence.
 */
import java.util.*;

public class stringFormat{
    
    public static void convert(String[] text){
        int max= 0;
        for(int i=0; i< text.length; ++i){
        	if(text[i].split(" ").length > max)
        		max= text[i].split(" ").length;
        }
        String[] verticalText= new String[max];
        for(int i=0; i< max; ++i){
        	verticalText[i]="";
        	for(int j=0; j< text.length; ++j){       	
        		String word=" ";
        		if(text[j].split(" ").length >=i+1)// length should be 5, 4, 6 respectively
        			word= text[j].split(" ")[i];
        		
        		verticalText[i]+= word +"         ";
        	}
        	verticalText[i].substring(0, verticalText[i].length()-1 );// remove " ";
        }
        for(String line: verticalText){
        	System.out.println(line);
        }
    }
    
    public static void main(String[] args){
        String[] text={"epic is a healthcare company.",
        		"interviewing for software developer.",
        		"print this vertically sentence by sentence."};
        convert(text);
        System.out.println();
        
    }
    
}
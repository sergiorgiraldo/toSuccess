package ll;
/*
Unique Number
Write, efficient code for extracting unique elements from a sorted list of array.
 e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
*/
import java.util.*;

public class uniqueNumber{
    
    public static void extract(int[] arr){
        int index=1;
        for(int i=1; i<arr.length; ++i){
        	if(arr[i]== arr[i-1]){
        		continue;
        	}else{
        		arr[index]= arr[i];
        		index++;
        	}
        }
        for(int i=0; i<index; ++i)
        	System.out.println(arr[i]);
    }
    
    public static void main(String[] args){
        int arr[]= {1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9};
        extract(arr);
        System.out.println();
        
    }
    
}

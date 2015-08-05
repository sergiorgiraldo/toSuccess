/*find the kth smallest number in a array*/
import java.util.*;

public class quickSelect{
    
    public static int quickselect(int[] arr, int k, int left, int right){
        if(left== right)
            return arr[left];
        int p= partition(arr, left, right);
        if(k==p)
            return arr[p];
        else if(k < p) // kth number is in the left part
            return quickselect(arr, k, left, p-1);
        else
            return quickselect(arr, k, p+1, right);
    }
    public static int partition(int[] arr, int left, int right){
        int pivot= arr[right];
        int pointer= left;
        for(int i=left; i< right; ++i){
            if(arr[i] < pivot){
                int t= arr[pointer];
                arr[pointer]= arr[i];
                arr[i]= t;
                pointer++;
            }
        }
        int t= arr[pointer];
        arr[pointer]= arr[right];
        arr[right]= t;
        
        return pointer;
    }
    
    public static void main(String[] args){
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8};
        // find median
        int k=-1;
        if(arr.length%2==0)
            k= arr.length/2-1;
        else
            k= arr.length/2;
        int res= quickselect(arr, k, 0, arr.length-1);
         System.out.println(res);
 
    }
    
}
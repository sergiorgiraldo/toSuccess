// quick sort is the best practical choice: 1) average time is O(NlogN) with small constant factors.  2) in-place
// quick sort is based on divide-and-conquer, time/space complexity can be computed via recurrence
// key part is Partition, which puts elements smaller than pivot into the left part and elements larger than pivot into the right region, O(n)
// worst case partition: T(n)= T(n-1) + O(n)-----> O(n^2)
// best case:  T(n)= 2T(n/2) + O(n) --------> O(nlogn)
import java.util.Arrays;

class quickSort{
    
    public static int  partition1(int[] arr, int left, int right){
        System.out.println(Arrays.toString(arr));
        int pivot= arr[left];
        int i=left;
        int j=right;
        while(i <= j){
            while(arr[i] < pivot )// no equal, first element never get exchanged, will cause stackoverflow
                i++;
            while(arr[j] > pivot )
                j--;
            
            if( i<= j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
                j--;
            }
        }
        // j=i-1, i=j+1
        return i;
    }
    
    public static int partition2(int[] arr, int left, int right){
        System.out.println(Arrays.toString(arr));
        int pivot= arr[right];
        int pointer=left;
        
        for(int i=left; i< right; ++i){
            if(arr[i] < pivot){
                int t= arr[pointer];
                arr[pointer]= arr[i];
                arr[i]=t;
                pointer++;   // swap arr[pointer] and arr[i]
            }
        }
        int t= arr[pointer];
        arr[pointer]= arr[right];
        arr[right]= t; // move pivot to the right position
        
        return pointer;
    }
    
    public static void quicksort(int[] arr, int left, int right){
        /*int q=partition1(arr, left, right);
        System.out.println(q);

        if(left < q-1)
            quicksort(arr, left, q-1);
        if( right > q)
            quicksort(arr, q, right);*/
        
        int q=partition2(arr, left, right);
        System.out.println(q);
        if(left < q-1) // can not equal to q, will reuse the qth element as pivot and cause stackoverflow
            quicksort(arr, left, q-1);
        if( right > q+1)
            quicksort(arr, q+1, right);
       
    }
    
    public static void main(String[] args){
        int[] arr= {5,3, 2, 6, 4, 1, 3, 7};
        int[] arr1={5, 4, 3, 2, 1};
        
        quicksort(arr1, 0, arr1.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
/*
 The running time of quicksort depends on whether the partition is balanced or not, and this in turn depends on which elements are used for pivot.
 1. How would you modify quicksort to sort in non-increasing order?
 rewrite the compare to: arr[i] > pivot
 2. choose the pivot
  choosing either a random index for the pivot
  choosing the middle index of the partition 
  (especially for longer partitions) choosing the median of the first, middle and last element of the partition for the pivot
 
 (lo + hi)/2, may cause overflow and provide an invalid pivot index. This can be overcome by using, for example, lo + (hi-lo)/2 to index the middle element,
 3.Repeated elements
  separates the values into three groups: values less than the pivot, values equal to the pivot, and values greater than the pivot.
 
 */

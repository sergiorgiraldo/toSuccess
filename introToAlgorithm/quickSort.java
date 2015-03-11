// quick sort is the best practical choice: 1) average time is O(NlogN) with small constant factors.  2) in-place
// quick sort is based on divide-and-conquer, time/space complexity can be computed via recurrence
// key part is Partition, which puts elements smaller than pivot into the left part and elements larger than pivot into the right region, O(n)?
import java.util.Arrays;

class quickSort{
    
    public static void  quicksort1(int[] arr, int left, int right){
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
        if(left < j)
            quicksort(arr, left, j);
        if( right > i)
            quicksort(arr, i, right);
        
    }
    
    public static void quicksort2(int[] arr, int left, int right){
        System.out.println(Arrays.toString(arr));
        int pivot= arr[left];
        int i=left;
        int j=right;
        
    
    }
    
    public static void main(String[] args){
        int[] arr= {5,3, 2, 6, 4, 1, 3, 7};
        quicksort1(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
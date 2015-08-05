// divide and conquer, stable sort
// O(nlogn), O(n)
import java.util.Arrays;

public class mergeSort{
    
    public static void mergesort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid=left+ (right - left)/2;
        mergesort(arr, left, mid);
        mergesort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    
    public static void merge(int[] arr, int left, int mid, int right){
        System.out.println(Arrays.toString(arr));
        
        int[] helper=new int[arr.length];
        int i=left, j=mid+1, k=left;
        
        for(int t=0; t< arr.length; ++t){
            helper[t]= arr[t];
        }
        
        while(i <= mid  && j <= right){
            if(helper[i] < helper[j] ){
                arr[k]= helper[i];
                i++;
            }else{
                arr[k]=helper[j];
                j++;
            }
            k++;
        }
       
        while(i <= mid){
            arr[k]= helper[i];
            i++;
            k++;
        }
        while(j <= right){
            arr[k]= helper[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        int[] arr={0, 4, 3, 5, 2, 1};
        mergesort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        
    }

}
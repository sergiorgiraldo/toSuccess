import java.util.*;

public class binarySearch{
    
    static ArrayList<Integer> res;
    public static void search(int[] arr, int target){
        int left=0, right=arr.length-1;
        while(left <= right){
            int mid= left+ (right -left)/2;
            if(arr[mid] == target){
                res.add(mid);
                int t=mid;
                while(arr[--mid] == target)
                    res.add(mid);
                mid=t;
                while(arr[++mid] == target)
                    res.add(mid);
                return;
            }else if(arr[mid] < target){
                left=mid+1;
            }else
                right=mid-1;
        }
    
    }
    public static void main(String [] args){
        res=new ArrayList<Integer>();
        int[] arr={1, 2, 3, 3, 4, 4, 5, 7};
        search(arr, 3);
        System.out.println(res.toString());
    }

}

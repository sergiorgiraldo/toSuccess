/*
 Largest Sum Sub Array
Find the largest sum contiguous sub array. The length of the returned sub array must beat least of length 2.
*/
import java.util.*;

public class largestSumSubarray{
    
    public static int solution(int[] A){
        int globalmax=A[0], localmax=A[0], count=0;
        for(int i=0; i<A.length; ++i){
            if(localmax+ A[i] < A[i]){
                localmax= A[i];
                count=0;
            }else{
                localmax+=A[i];
                count++;
            }
            if(localmax >globalmax && count>=2)
                globalmax=localmax;
        }
        return globalmax;
        
    }
    
    public static void main(String[] args){
        int [] arr={-3, 4, -1, 3,1, -1};
        System.out.println(solution(arr));
        
    }
    
}

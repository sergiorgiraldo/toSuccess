/* known as Fisher–Yates shuffle: 
http://en.wikipedia.org/wiki/Fisher–Yates_shuffle

To shuffle an array a of n elements (indices 0..n-1):
  for i from n − 1 downto 1 do
       j ← random integer such that 0 ≤ j ≤ i
       exchange a[j] and a[i]
 
 The idea is simple: suppose (i, end] is shuffled, now pick a pos randomly from [0, i], and generate the [i, end] shuffle
 
 */

import java.util.*;

public class shuffle{
    
    public static void doshuffle(int[] nums){
        Random rand= new Random();
        for(int i=nums.length-1; i>=1; --i){
        /*
            public int nextInt(int n) where n is the bound on the random number to be returned. Must be positive.
          */
            int k= rand.nextInt(i);// crucial
            //System.out.println(k);
            int t= nums[i];
            nums[i]= nums[k];
            nums[k]=t;
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    public static void main(String[] args){
        
        int []nums={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        doshuffle(nums);
        
    }
    
}
import java.util.*;

public class ThreeSum{
    
     public void threesum(int[] arr, int target){
     	  if(arr.length==0) return;
     	  ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
          // sorting is necessary
     	  Arrays.sort(arr);
          // for each arr[i], we try to find arr[l] and arr[r] in subarray[i, len] that adds up to the target
     	  for(int i=0; i< arr.length; ++i){
     	  	 if(i>0 && arr[i]== arr[i-1]) continue;
     	  	 int l=i+1, r= arr.length-1;
     	  	 while(l < r){
     	  	 	int sum= arr[i]+ arr[l]+ arr[r];
     	  	 	if(sum == target){// find one solution
     	  	 		ArrayList<Integer> tmp= new ArrayList<Integer>();
     	  	 		tmp.add(arr[i]);
     	  	 		tmp.add(arr[l]);
     	  	 		tmp.add(arr[r]);
     	  	 		result.add(tmp);
     	  	 		l++;
     	  	 		r--;
     	  	 		while(l< r && arr[l]== arr[l-1])// remove duplicates
     	  	 			l++;
     	  	 		while(l < r && arr[r]== arr[r+1])
     	  	 			r--;
     	  	 	}else if(sum < target){// after sorting, we know we should move l pointer to get bigger sum
     	  	 		l++;
     	  	 	}else{// move r pointer to get smaller sum
     	  	 		r--;
     	  	 	}
     	  	 }

     	  }
     	  System.out.println(result);
         
     }
    
    public static void main(String[] args){
    	ThreeSum s= new ThreeSum();
        int[] arr={1, 1, 1, -1, -1, 2, 0};
        s.threesum(arr, 0);
 
    }
    
}
##Longest Increasing Subsequence

Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Example
```
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
```

Challenge
Time complexity O(n^2) or O(nlogn)

Clarification
What's the definition of longest increasing subsequence?

    * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.  

    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem


###Solution 1：
Let arr[0..n-1] be the input array and L(i) be the length of the LIS till index i such that arr[i] is part of LIS and arr[i] is the last element in LIS, then L(i) can be recursively written as.
L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then L(i) = 1. 
To get LIS of a given array, we need to return max(L(i)) where 0 < i < n

```
Time: O(n^2)
Space: O(n)

```

####Algorithm:
 dp[i]= Math.max(dp[i], dp[j]+1);

```java
 public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int[] dp= new int[nums.length];// denotes LIS(i) for nums[0, i];
        if(nums.length==0) return 0;
        //init, no need ?--> result should at least be 1
        for(int i=0; i<nums.length; ++i)
            dp[i]=1;
    
        for(int i=0; i< nums.length; ++i){
            for(int j=0; j<i; ++j){
                if(nums[j] <= nums[i])
                    dp[i]= Math.max(dp[i], dp[j]+1);
            }
        }
        int ret=1;
        for(int i=0; i<nums.length; ++i)
            ret= Math.max(ret, dp[i]);
        return ret;
    }


```

###Solution 2: 

```
Time:  O(nlogn)
Space: O(n)
```
####Algorithm:

[please refer](http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/)

Our strategy determined by the following conditions,

1. If A[i] is largest among all end candidates of active list, we extend it by A[i].

3. If A[i] is in between, we will find a largest end element that is smaller than A[i]. replace that element by A[i].


```java

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        ArrayList<Integer> res= new ArrayList<Integer>();
        for(int n: nums)
            update(res, n);
        return res.size();
    }
    public void update(ArrayList<Integer> list, int target){
        int pos= searchInsert(list, target);
        if(pos==list.size()){
            list.add(target);
        }else{
            list.set(pos, target);
        }
        
    }
    // search right most insert position
    public int searchInsert(ArrayList<Integer>  A, int target) {
        // write your code here
        if(A.size()==0) return 0;
        int l=0, r= A.size()-1;
        while(l <= r){
            int m= (l+r)/2;
            if(A.get(m) <= target){
                l= m+1;
            }else{
                r= m-1;
            }
        }
        return l;
    }

```
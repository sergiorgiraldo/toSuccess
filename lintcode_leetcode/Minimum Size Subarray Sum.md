## Minimum Size Subarray Sum
[Minimum Size Subarray Sum](http://www.lintcode.com/en/problem/minimum-size-subarray-sum/)

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

```
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
```
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


###Solution 1：
```
Time: O（n)
Space: O(1)

```

####Algorithm:
A typical two pointer problem. while sum > s, increase r； while sum < s, increase l and check whether this shunking will update the global min length.

```java
 public int minimumSize(int[] nums, int s) {
        // write your code here
        int min= nums.length+1;
        if(nums.length==0) return -1;
        int l=0, r= 0, localsum= 0;
        while(r < nums.length){
            while(localsum < s && r< nums.length){
                localsum+= nums[r];
                r++;
            }
            while(localsum >= s && l<=r){
                min=Math.min(min, r-l);
                localsum-= nums[l];
                l++;
            }
            
        }
        return min==nums.length+1 ? -1 : min;
 }


```

###Solution 2: 

```
Time: O(nlogn)
Space: 
```
####Algorithm:


```java



```
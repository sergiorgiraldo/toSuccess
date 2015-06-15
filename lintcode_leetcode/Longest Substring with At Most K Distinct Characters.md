## Longest Substring with At Most K Distinct Characters

Given a string s, find the length of the longest substring T that contains at most k distinct characters.

```
Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.
```
Challenge
O(n), n is the size of the string s.


###Solution 1：
```
Time:  O(n)
Space: O(n)

```

Hashmap could be used to record the disctinct characters. _Two pointers_ are used for traversing, say l and r.  if meet a new char, check whether mp.size()>k. If so, increase l & update map so that the size is kept. Should update max in each loop. 

Nothing difficult, but must properly update those pointers. 

####Algorithm:


```java

public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int l=0, r= 0;
        if(s.length()==0)
            return 0;
        int max=0;
        HashMap<Character, Integer> set= new  HashMap<Character, Integer>();
        
        while( r < s.length()){
            char rc= s.charAt(r);
            if(set.containsKey(rc)){
                set.put(rc, set.get(rc)+1);
            }else{// new char
                set.put(rc, 1);
                while(set.size()>k){
                   char lc= s.charAt(l);
                   if(set.get(lc)>0){
                       set.put(lc, set.get(lc)-1);
                       if(set.get(lc)<=0)
                            set.remove(lc);
                   }else{
                       //
                   }
                   l++;
                }
            }
            max= Math.max(max, r-l+1);
            r++;
        }
        return max;
    }


```

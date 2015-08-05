## Submatrix Sum 
[Submatrix Sum](http://www.lintcode.com/en/problem/submatrix-sum/)

Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.
Have you met this question in a real interview?

Example
```
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]

return [(1,1), (2,2)]
```
Challenge
O(n^3) time.



###Solution 1：
```
Time:  O(n^3)
Space: O(n)

```

####Algorithm:
Building block is [Subarray Sum](http://www.lintcode.com/en/problem/subarray-sum/). 核心思想是将2D matrix降维成1D， 这样就可以调用[Subarray Sum](http://www.lintcode.com/en/problem/subarray-sum/)来解了。 有两种情况：
- matrix.length >= matrix[0].length: 

	loop through the left& right boarder,O(n^2)， sum every row array sandwiched by the left and right boarder, O(n). Perform Subarray sum on the sum array to get the top and bottom boarder for the result 

<img src="https://lh3.googleusercontent.com/AHL_AaWgFzYLEsmxUPW4-dUiajA6wBjs2gXpeJdkH1o=w377-h68-no">

- matrix.length < matrix[0].length: 

	Similar to above. 

```java
public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        // all submatrix n^4
        //  reduced to subarray sum
         int[][] ret= {{-1, -1}, {-1, -1}};
        if(matrix.length==0) return  ret;
        int n= matrix.length,m= matrix[0].length;
        
        if(n < m){
            return searchRows(matrix, n, m);
        }else{
            return searchCols(matrix, n, m);
        }
    }
    // search horizontally, that is, perform subarraySum on sum of rows  
    public int[][] searchRows(int[][] matrix, int n, int m){
        int[][] ret= {{-1, -1}, {-1, -1}};
        for(int top=0; top< n; ++top){
            int[] rows= new int[m]; 
            for(int bot= top; bot< n; ++bot){// 
                for(int i=0; i< m; ++i){
                    rows[i]+= matrix[bot][i];// for each bot, sum that row
                }
                ArrayList<Integer> lr=subarraySum(rows); 
                if(lr.size()!=0){
                    int left= lr.get(0), right= lr.get(1);
                    ret[0][0]=top;
                    ret[0][1]= left;
                    ret[1][0]= bot;
                    ret[1][1]= right;
                    return ret;
                }
            }
        }
        return ret;
    }
    
    // search vertically, that is, perform subarraySum on Sum of col
    public int[][] searchCols(int[][] matrix, int n, int m){
        int[][] ret= {{-1, -1}, {-1, -1}};
        for(int left=0; left< m; ++left){
            int[] cols= new int[n]; 
            for(int right= left; right< m; ++right){// 
                for(int i=0; i< n; ++i){
                    cols[i]+= matrix[i][right];// for each right, sum that col
                }
                ArrayList<Integer> lr=subarraySum(cols); 
                if(lr.size()!=0){
                    int top= lr.get(0), bot= lr.get(1);
                    ret[0][0]=top;
                    ret[0][1]= left;
                    ret[1][0]= bot;
                    ret[1][1]= right;
                    return ret;
                }
            }
        }
        return ret;
    }
    // use prefix sum to find the result
    public ArrayList<Integer> subarraySum(int[] nums) {
        
        ArrayList<Integer>  res= new ArrayList<Integer> ();
        HashMap<Integer, Integer> mp= new HashMap<Integer, Integer> ();
        int sum=0;
        mp.put(0, 0);// init
        for(int i=0; i< nums.length; ++i){
            if(nums[i]==0){
                res.add(i);
                res.add(i);
                return res;
            }
            if(mp.containsKey(sum)){
                res.add(mp.get(sum)+1);
                res.add(i);
                return res;
            }
            mp.put(sum, i);
        }
        return res;
    }


```


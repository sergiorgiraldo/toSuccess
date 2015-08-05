## Divide Two Integers


Divide two integers without using multiplication, division and mod operator.

If it is overflow, return 2147483647

```
Example
Given dividend = 100 and divisor = 9, return 11.
```

###Solution 1：
Interesting solution:  a/b= e^(ln(a)- ln(b)).

```
Time: O(1)  
Space: O(1)

```

####Algorithm:


```java
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor==0) return 0;
        boolean ispos= dividend > 0 && divisor>0 || dividend <0 && divisor <0;
        long n= Math.abs((long)dividend);
        long m= Math.abs((long)divisor);
        long ret= (long)Math.exp(Math.log(n)- Math.log(m));// log is e base
        
        if(ispos && ret> Integer.MAX_VALUE ) // overflow
            return Integer.MAX_VALUE;
        
        return ispos? (int)ret: (int)-ret;
    }


```

###Solution 2: 

The standard solution: Every number has a binary representation, that is n= 2^k + 2^(k-1) + 2^(k-2) + ... + 2 + 1, so we can deduct the dividend by (2^i)* divisor each time, this will decrease the runtime efficiently. For example, 25/3, first, 25- 3= 22, then 22- 3*2=16, then 16- 3*2^2= 4. if remaining < (2^i)* divisor, start over, until dividend < divisor. 

Must take care of overflow problems. Use long is easy, but may not meet the requirement. 
```
Time:  O(logn)
Space: O(1)
```
####Algorithm:


```java

    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor==0) return 0;
        boolean ispos= dividend > 0 && divisor>0 || dividend <0 && divisor <0;
        long n= Math.abs((long)dividend);
        long m= Math.abs((long)divisor);
        
        long ret=0;
        while(n >= m){ // 
            long inc= m;
            int count=0; // record the counts of inc's left shift 
            while(inc <= n){
                n-= inc; // dividend deduct a inc
                inc <<=1;// inc^2
                ret+= (1<< count);
                count++;
            }
        }
        
        if(ispos && ret > Integer.MAX_VALUE)
            ret= Integer.MAX_VALUE;
        if(!ispos && ret-1> Integer.MAX_VALUE)
            ret= Integer.MAX_VALUE;
        
        return ispos? (int)ret: (int)-ret;
    }


```
## Max Points on a Line

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example
```
Given 4 points: (1,2), (3,6), (0,0), (1,3).

The maximum number is 3.
```

###Solution 1：
```
Time:  O(n^2)
Space: O(n)

```

####Algorithm:
The algorithm is pretty straight-forward: for every point, say s, we compute the gradient of line that forms by s and other point. However, there are several tricky parts:

1. what happens if there is duplicate point in the array? for every source point s, if we meet a duplicate, we know every line now has an additional point that lies at s. We just need to record the count of duplicates, and add the count to every gradient. 

2. In java's HashMap, 0.0 and -0.0 are different keys (WTF).

3. Vertical line should be handled. Besides, every time we count a new gradient, we put(gradient, 2) . It's must be a 2 !

```java
public int maxPoints(Point[] points) {
        if(points==null || points.length ==0 )
            return 0;
        int max=1;
        
        for(int i=0; i< points.length; ++i){
            int dup=0;
            HashMap<Double, Integer> mp= new HashMap<Double, Integer>();
            mp.put(Double.MAX_VALUE, 1);
            for(int j=i+1; j< points.length; ++j){
                if(points[j].x== points[i].x && points[i].y== points[j].y){
                    dup++;
                    continue;
                }
                if(points[i].x== points[j].x)
                    mp.put(Double.MAX_VALUE, mp.get(Double.MAX_VALUE)+1);
                else{
                    double grad=1.0*(points[i].y- points[j].y)/(points[i].x- points[j].x);
                    if(mp.containsKey(grad))
                        mp.put(grad, mp.get(grad)+1);
                    else
                        mp.put(grad, 2);
                }
            }
            max= Math.max(max, Collections.max(mp.values())+dup);
        }
        return max;
    }
}
```


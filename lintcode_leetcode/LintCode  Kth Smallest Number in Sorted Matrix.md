## Kth Smallest Number in Sorted Matrix
[Kth Smallest Number in Sorted Matrix](http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/)

Find the kth smallest number in at row and column sorted matrix.

Example
```
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]

return 5
```

Do it in O(k log n), n is the maximal number in width and height.

There are two solutions： 1） BST 2)PriorityQueue 

###Solution 1：


###Solution 2: 
Similar to [Merge k Sorted Lists](http://www.lintcode.com/en/problem/merge-k-sorted-lists/). It's fundamentally a merge sort algorithm: maintain a PriorityQueue, initialized with the first row or column and poll the top for k times. So the crux here is how to update the heap after polling: get the next element from the same row of the top if initialized by first column, or get the next element from the same column of the top if initialized by the first row. 
```
Time:  O(klog(min(m, n, k))
Space: O(min(m, n, k))
```
###Algorithm:

Lintcode奇葩的设置，最后一个test case Memory Limit Exceeded. 

```java

public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix.length==0)
            return -1;
        int rownum= matrix.length, colnum=matrix[0].length;
        int min=matrix[rownum-1][colnum-1];
        // init comparator
        Comparator<Node> cp= new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return a.val- b.val;
            }
        };
        PriorityQueue<Node> pq= new PriorityQueue<Node>(Math.max(rownum, colnum), cp);//min heap
        boolean rowflag= rownum< colnum ? true: false;

        // init
        if(rowflag){// init with the first row numbers
            for(int i=0; i< colnum; ++i){
                Node tmp= new Node(matrix[0][i], 0, i);
                pq.offer(tmp);
            }
        }else{
            for(int i=0; i< rownum; ++i){
                Node tmp= new Node(matrix[i][0], i, 0);
                pq.offer(tmp);
            }
        }

        // poll & update
        int ret=-1;
        while(k>0){
            // remove the minimal element k time
            Node cur= pq.poll();
            if(k==1){
                ret= cur.val;
            }
            if(rowflag){
                if(cur.x+1 < rownum){
                    Node tmp= new Node(matrix[cur.x+1][cur.y], cur.x+1, cur.y);
                    pq.offer(tmp);
                }
            }else{
                if(cur.y+1 < colnum){
                    Node tmp= new Node(matrix[cur.x][cur.y+1], cur.x, cur.y+1);
                    pq.offer(tmp);
                }
            }
            k--;
        }
        return ret;
    }
    class Node{
        int val;
        int x, y;
        public Node(int val, int x, int y){
            this.val=val;
            this.x= x;
            this.y= y;
        }
            
    }

```
## Populating Next Right Pointers in Each Node II 

Follow up for problem "[Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.

For example,

```
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

```
###Solution 1：
```
Time:  O(n)
Space: O(1)

```

####Algorithm:
We know it's a level order traversal, but we want to use constant space. The algorithm is simple: when traversing current level, set the "next" pointers for next level. What we need here is three pointers that indicate: 1) position of current level 2) next level's start point 3) set the "next" pointer for next level using a "prev" indicator 

```java

    public void connect(TreeLinkNode root) {
        // set next level when traversing current level, so that we can reduce the space into O(1)
        TreeLinkNode cur= root;
        while(cur!=null){
            TreeLinkNode prev= null;
            TreeLinkNode nextlevel=null;// must initialized here
            while(cur!=null){// not the end of current level
                if(cur.left!=null){
                    if(nextlevel==null)
                        nextlevel= cur.left;
                    if(prev!=null)
                        prev.next= cur.left;
                    prev= cur.left;
                }
                if(cur.right!=null){
                   if(nextlevel==null)
                        nextlevel= cur.right;
                    if(prev!=null)
                        prev.next= cur.right;
                    prev= cur.right;
                }
                cur= cur.next;
            }
            cur= nextlevel;
        }

```


Tree Problems from lintcode and leetcode, categorized 

### Tree的结构 
1. [Minimum Depth of Binary Tree](http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/)
2. [Subtree](http://www.lintcode.com/en/problem/subtree/)
3. []()
4. []()

### Tree Traversal
1. [Binary Tree Level Order Traversal]()
2. [Binary Tree Level Order Traversal II](http://www.lintcode.com/en/problem/binary-tree-level-order-traversal-ii/)
    - q to store nodes by level
    - a variable 'level' to count how many nodes should be visited in each level
3. [Binary Tree Zigzag Level Order Traversal](http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/)
    - BFS by stacks/queue/arraylist, if using queue, must reverse sometimes. 
    - best using stacks 
    
4. [Binary Tree Inorder Traversal](http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/)
    - left, root, right
    - keep traversal until the leftmost node(leaf, or node with only right child)
    - go to leftmost's right
    ```
        while(!s.isEmpty() || cur!=null){
            if(cur!=null){
                s.push(cur);
                cur= cur.left;
            }else{
                cur= s.pop();
                res.add(cur.val);
                cur= cur.right;
            }
        }
    ```
5. [Binary Tree Preorder Traversal](http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/)
    - root, left, right 
    - DFS standard code: push right child first to stack !
    
6. [Binary Tree Postorder Traversal](http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/)
    - left, right, root
    - keep traversal until the leftmost node(leaf, or node with only right child)
    - reference the leftmost child, check if already visited the right child, if yes, pop and visit father(next node on stack). otherwise, go to the right child
    
    ```
        while(!s.isEmpty() || cur!=null){
            if(cur!=null){
                s.push(cur);
                cur= cur.left;
            }else{
                TreeNode top= s.peek();
                if(top.right!=null && prev!= top.right)
                    cur= top.right;
                else{
                    res.add(top.val);
                    prev= s.pop();
                }
            }
        }
    ```
### Tree Serialization & Deserialization
1. [Max Tree](http://www.lintcode.com/en/problem/max-tree/)
    -
2. [Binary Tree Serialization](http://www.lintcode.com/en/problem/binary-tree-serialization/)
    - both functions using BFS
    - when serialization, using "," to seperate numbers( 14, 4 )
3. []()
4. []()
2. []()
3. []()
4. []()

### Advanced Tree: Trie
1. []()
2. []()
3. []()
4. []()

### Advanced Tree: Segment Tree
1. []()
2. []()
3. []()
4. []()
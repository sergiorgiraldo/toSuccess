###Queue
	


###Stack
#### Basics
1. [Min Stack](http://www.lintcode.com/en/problem/min-stack/)
    - two stacks, one stores all coming values, one only stores the value that are smaller than top's, pop when the two tops are equal
    
2. [Simplify Path](http://www.lintcode.com/en/problem/simplify-path/)
    - stack keeps the true path, meet "." do nothing, meet ".." pop. if stack is empty, return "/"

3. [Implement Queue by Two Stacks](http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/)
    - something like reverse string: one stack get the reversed order, one stack reverse the reversed order
    
#### RPN and expression evaluation
1. [Convert Expression to Polish Notation](http://www.lintcode.com/en/problem/convert-expression-to-polish-notation/)
    - PN is prefix expressiong
    - predefine the order of operation
    - one stack to store lower ranked(<=) operators(top always has higher priority)  & one output string
    - scan from right to left:
            - digit: append at the front of output stream
            - operator: pop all higher prioritized operators and add to the front of the output stream, push current operator
            - pop everything left from the stack when loop ends
    - remove parentheses: always push ). pop everything until ) when meeting (
    
2. [Convert Expression to Reverse Polish Notation](http://www.lintcode.com/en/problem/convert-expression-to-reverse-polish-notation/)
    - almost same as above, except:
        - scan from left to right
        - stack store lower ranked(only < )
        - append at the end of output stream


3. [Expression Evaluation](http://www.lintcode.com/en/problem/expression-evaluation/)
    - using stack for either RPN/PN
    - scan from left to right for RPN, from right to left for PN
    - take care of the order when - and / (stack)
4. [Expression Tree Build](http://www.lintcode.com/en/problem/expression-tree-build/)
    - convert to RPN/PN first
    - similar to serialize Binary Tree, do it recursively:
        ```
        if(!isOperator(pn.get(pos)))
            return root;
        pos++;
        root.left= helper(pn);
        pos++;
        root.right= helper(pn);
        
        ``

###Heap
1. [Merge k Sorted Lists](http://www.lintcode.com/en/problem/merge-k-sorted-lists/)
2. [Kth Smallest Number in Sorted Matrix](http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/)
	- key: merge sort: O(nlogn), priorityqueue: O(klogn).  怎样更新heap? init with a row number, pop and get next from the same column 
3. []()
4. []()

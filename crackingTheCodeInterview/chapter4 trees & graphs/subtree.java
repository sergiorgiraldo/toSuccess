/*
You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes
Create an algorithm to decide if T2 is a subtree of T1
*/

import java.util.*;

public class subtree{
    // BFS to find the node same to T2's root, then check if the two trees are same
    // time: O(n + k*m ),  k is the number of times bfs find t2's root
    public static void isSubtree(TreeNode t1, TreeNode t2){
        
        System.out.println();
    }
    
    public boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1 ==null && t2== null)
            return true;
        if(t1== null || t2== null)
            return false;
        if(t1.val != t2.val)
            return false;
        return isSameTree(t1.left, t2.left)
                && isSameTree(t1.right, t2.right);
    }
    
    public static void main(String[] args){
        
        
        
    }
    
}
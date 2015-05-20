/*
You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes
Create an algorithm to decide if T2 is a subtree of T1
*/

import java.util.*;

public class subtree{
    // DFS to find the node same to T2's root, then check if the two trees are same
    // time: O(n + k*m ),  k is the number of times Dfs find t2's root
    public static void isSubtree(TreeNode t1, TreeNode t2){
        boolean found= false;
        Stack<TreeNode> s= new Stack<TreeNode>();
        s.push(t1);
        while(!s.isEmpty()){
            TreeNode cur= s.pop();
            if(cur== t2){
                if(isSameTree(cur, t2)){
                    System.out.println("found !");
                    found= true;
                }
            }else{
                if(cur.left != null)
                    s.push(cur.left);
                if(cur.right != null)
                    s.push(cur.right);
            }
        }
        if(!found)
            System.out.println("not found !");
    }
    
    public static boolean isSameTree(TreeNode t1, TreeNode t2){
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
        TreeNode root= new TreeNode(0);
        root.left= new TreeNode(1);
        root.right= new TreeNode(2);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(4);
        
        TreeNode r= new TreeNode(5);
        isSubtree(root, root.left.left);
        isSubtree(root.left.left, r);
        
    }
    
}
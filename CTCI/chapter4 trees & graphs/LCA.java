/*

Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree Avoid storing additional nodes in a data structure 
 
NOTE: This is not necessarily a binary search tree

*/

import java.util.*;

/*
 Attempt #1:
 If each node has a link to its parent, we could trace p and q’s paths up until they intersect (treated as linkedlist intersection)
 */

public class LCA{
    
    /*
     Attempt #2:
     Alternatively, you could follow a chain in which p and q are on the same side That is, if p and q are both on the left of the node, branch left to look for the common ancestor When p and q are no longer on the same side, you must have found the first common ancestor
     
     not efficient, touch too many nodes for too many times.
     */
    public static void findLCA1(TreeNode root, TreeNode t1, TreeNode t2){
        if(isChild(root.left, t1) && isChild(root.left, t2)){
            findLCA1(root.left, t1, t2);
            
        }else if(isChild(root.right, t1) && isChild(root.right, t2)){
            findLCA1(root.right, t1, t2);
        }
        
        System.out.println(root.val);
    }
    public static boolean isChild(TreeNode t1, TreeNode t2){
        // t2 is the child of t1
        if(t1== null) return false;
        if(t1==t2) return true;
        return isChild(t1.left, t2) || isChild(t1.right, t2);
    }
    
    /*
     Attemp #3:
     The idea is to traverse the tree starting from root. If any of the given node matches with root, then root is LCA (assuming that both keys are present). If root doesn’t match with any, we recur for left and right subtree. The node which has one node present in its left subtree and the other node present in right subtree is the LCA. If both nodes lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
     http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
     
    */
    
    public static TreeNode findLCA2(TreeNode root, TreeNode t1, TreeNode t2){
        
        if(root== null || t1== null || t2==null)
            return null;
        
        // If either t1 or t2 matches with root, report
        // the presence by returning root (Note that if one node is
        // the ancestor of the other, then the it becomes LCA
        
        if(root== t1 || root== t2){
            return root;
        }
        
        TreeNode lsub= findLCA2(root.left, t1, t2);
        TreeNode rsub= findLCA2(root.right, t1, t2);
    
        // If both of the above calls return Non-NULL, then one
        // node present in once subtree and other is present in other,
        // So this node is the LCA
        if(lsub != null  && rsub != null){
            return root;
        }
        
        // both nodes lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
        return lsub != null ? lsub : rsub;
    }
    
    public static void main(String[] args){
        
        TreeNode root= new TreeNode(0);
        root.left= new TreeNode(1);
        root.right= new TreeNode(2);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(4);
        
        TreeNode res= findLCA2(root, root.right, root.left.left);
        System.out.println(res.val);
    }
    
}
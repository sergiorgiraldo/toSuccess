/*

Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given node in a binary search tree where each node has a link to its parent

*/

import java.util.*;

class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 parent;
    public TreeNode2(int val){
        this.val= val;
        
    }
}


public class inorderSuccessorNode{
    // left root right
    public static void findNext(TreeNode2 node){
        // node is a left child-->parent
        // node is a right child --> parent's parent
        // node is a parent-> right subtree left most child
        
        if(node == null)
            return;
        
        TreeNode2 res;
        if(node.parent==null || node.right != null){
            res=leftMostChild(node.right);// node.right, not node
        }else{
            while((res= node.parent) != null){
                if(res.left== node){// node is a left child
                    break;
                }
                node= res;// node is the right child(parent is grandparent's left child )
            }
        }
        
        if(res==null)
            System.out.println("next is null");
        else
            System.out.println(res.val);
    }
    
    public static TreeNode2 leftMostChild(TreeNode2 t){
        if(t==null)
            return null;
        while(t.left != null)
            t= t.left;
        return t;
    }
    
    public static void main(String[] args){
        TreeNode2 root= new TreeNode2(0);
        TreeNode2 t1= new TreeNode2(1);
        TreeNode2 t2= new TreeNode2(2);
        TreeNode2 t3= new TreeNode2(3);
        TreeNode2 t4= new TreeNode2(4);
        
        root.left= t1;
        root.right= t2;
        t1.left= t3;
        t1.right= t4;
        t3.parent= t1;
        t4.parent= t1;
        t2.parent= root;
        t1.parent= root;
        
        findNext(root);
        findNext(t1);
        findNext(t2);
        findNext(t3);
        findNext(t4);
        
    }
    
}
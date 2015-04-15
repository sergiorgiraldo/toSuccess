/*
 mock leetcode tree's decoding and encoding
 
 Follow up:
 a sentinel is required to represent empty nodes. What if we need to store strings that can contain any characters (including the sentinel) in the binary tree?
 
*/

import java.util.*;

public class decodeTree{
    
    // key is to maintain the decrease of s
    static String s;
    public static TreeNode decode(){
        if(s.length()==0)
            return null;
        
        char cur= s.charAt(0);
        
        if(cur=='#'){
            return null;
        }else{
            TreeNode node= new TreeNode(cur- '0');
            
            if(s.length() >0){
                s= s.substring(1);
                node.left= decode();
            }
            
            if(s.length() >0){
                s= s.substring(1);
                node.right= decode();
            }
            
		    
            return node;
        }
        
    }
    
    // using DFS((pre-order)
    // collection framework does not allow null object
    // use recursion
    static StringBuilder code= new StringBuilder();
    public static void encode(TreeNode root){
        if(root==null){
            code.append("#");
            return;
        }
        code.append(root.val);
        encode(root.left);
        encode(root.right);
        
    }
    
    public static void main(String[] args){
        
        TreeNode root= new TreeNode(0);
        root.left= new TreeNode(1);
        root.right= new TreeNode(2);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(4);
        encode(root);
        System.out.println(code.toString());
        //-------------
        s= code.toString();
        TreeNode detree= decode();
        System.out.println(detree.val);
        System.out.println(detree.left.val);
        System.out.println(detree.right.val);
        System.out.println(detree.left.left.val);
        System.out.println(detree.left.right.val);
    }
    
}
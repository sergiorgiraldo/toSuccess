/*
Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
*/

import java.util.*;

public class createBinaryTreeBySortedArray{
    
    public static TreeNode create(int[] arr, int start, int end){
        if(start > end)
            return null;
        int m= (start + end)/2;
        
        TreeNode root= new TreeNode(arr[m]);
        root.left = create(arr, start, m-1);
        root.right=  create(arr, m+1, end);
        return root;
    }
    
    public static void main(String[] args){
        
        int[] arr= {1, 2, 4, 5, 6, 8, 9, 10};
        TreeNode root= create(arr, 0, arr.length-1);
        
    }
    
}
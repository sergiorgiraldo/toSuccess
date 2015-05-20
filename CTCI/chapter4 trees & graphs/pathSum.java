/*
You are given a binary tree in which each node contains a value. 
Design an algorithm to print all paths which sum up to that value. 
Note that it can be any path in the tree - it does not have to start at the root.
*/

import java.util.*;

public class pathSum{
    // clever solution here: buffer all the path from root
    // at each level, check if current level could builds up a path of sum with previous ones
     public static void find(TreeNode root, ArrayList<Integer> buffer, int level, int sum){
         if(root==null)
         	return;
         buffer.add(root.val);
         int tmp= sum;
         for(int i= level; i>=0; --i){
   			tmp-= buffer.get(i);
   			if(tmp==0)
   				printPath(buffer, i, level);
         }

         find(root.left, new ArrayList<Integer> (buffer), level+1, sum);// must new buffer, visit in parellel
         find(root.right, new ArrayList<Integer> (buffer), level+1, sum);
    }

    public static void printPath(ArrayList<Integer> buffer, int i, int level){
    	for(int j=i; j<= level; ++j)
    		System.out.print(buffer.get(j)+" ");
    	System.out.println();
    }
    
    public static void main(String[] args){
        
        TreeNode root= new TreeNode(0);
        root.left= new TreeNode(1);
        root.right= new TreeNode(2);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(4);

 		find(root, new ArrayList<Integer> (), 0, 5 );
    }
    
}
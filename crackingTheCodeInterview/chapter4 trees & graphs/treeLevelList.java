/*
Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists)
*/


import java.util.*;

public class treeLevelList{
    
    public static void toList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res=
                new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);
        res.add(new LinkedList<TreeNode>(q));
        while(! q.isEmpty()){
            LinkedList<TreeNode> nextlevel = new LinkedList<TreeNode>();
            while(!q.isEmpty()){
                TreeNode cur= q.pop();
                if(cur.left != null)
                    nextlevel.add(cur.left);
                if(cur.right != null)
                    nextlevel.add(cur.right);
            }
            q= new LinkedList<TreeNode>(nextlevel);
            if(nextlevel.size() > 0)
                res.add(nextlevel);
        }
        
        for(LinkedList<TreeNode> l: res){
            for(TreeNode t: l){
                System.out.print(t.val + " ");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args){
        
        TreeNode root= new TreeNode(0);
        root.left= new TreeNode(1);
        root.right= new TreeNode(2);
        root.left.left= new TreeNode(3);
        toList(root);
    }
    
}
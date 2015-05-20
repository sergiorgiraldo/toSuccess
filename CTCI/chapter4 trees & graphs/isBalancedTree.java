/*Implement a function to check if a tree is balanced For the purposes of this question, a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one
*/


    
import java.util.*;

class isBalancedTree{
    
    static boolean result=true;
    // watch out, can not declared as "static", may lead to wrong answers here
    // more details : https://leetcode.com/faq/
    public static boolean isBalanced(TreeNode root) {
        result= true;
        getHeight(root);
        return result;
    }
    
    // in getHeight steps, may not balanced.
    public static int getHeight(TreeNode root){
        if(root== null)
            return 0;
        int l= getHeight(root.left);
        int r= getHeight(root.right);
        if(Math.abs(l-r) >1) result= false;
        return 1+ Math.max(l, r);
    }
    
    
   public static void main(String[] args){
       
       TreeNode root= new TreeNode(0);
       root.left=new TreeNode(1);
       System.out.println(isBalanced(root));
       
   }
        
}
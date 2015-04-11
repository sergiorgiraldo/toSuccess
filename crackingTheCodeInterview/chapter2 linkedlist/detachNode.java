/**
    * Delete a node in the middle of a singly linked list, given only access to that node
*/

import java.util.*;

public class detachNode{
    
    public static void helper(ListNode node){
        if(node== null || node.next==null)
            return;
        node.val= node.next.val;
        node.next= node.next.next;
    }
    
    public static void main(String[] args){
        int[] arr= {1, 4, 3, 1, 2, 5, 7, 8, 3, 2};
        ListNode h= new ListNode(arr);
        h.printList();
        
        helper(h.next.next.next);
        h.printList();
    }
    
}
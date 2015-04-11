
/**
 * Write code to remove duplicates from an unsorted linked list
 * e.g. [1,2,6,1,4,5,4] -> [1,2,6,4,5]
 * Note: use constant space
 */

import java.util.*;

public class removeDuplicates{
    
    // O(n) + O(n)
    public static void helper(ListNode head){
      
        ListNode dummy= new ListNode(-1);
        dummy.next= head;
        HashSet<Integer> set= new HashSet<Integer>();
        ListNode prev= head;
        while(head != null){
            if(set.contains(head.val)){
                prev.next= head.next;
                head= head.next;
            }else{
                set.add(head.val);
                prev= head;
                head= head.next;
            }
        }
    }
    // O(n^2)
    public static void helper2(ListNode head){
        // ListNode dummy= new ListNode(-1);
        //dummy.next= head;
        // if head does not change, we do not need dummy
        
        ListNode first= head, second= null, prev=null;
        
        while(first != null){
            second= first.next;
            prev= first;
            while(second !=null){
                if(first.val== second.val){
                    prev.next= second.next;
                    second= second.next;
                }else{
                    prev= second;
                    second= second.next;
                }
            }
            first= first.next;
        }
    }
    
    public static void main(String[] args){
        
        int[] arr= {1, 4, 3, 1, 2, 5, 7, 8, 3, 2};
        ListNode h= new ListNode(arr);
        h.printList();
        
        helper(h);
        h.printList();
        helper2(h);
        h.printList();
        
    }
    
}
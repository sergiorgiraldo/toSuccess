/* partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x
*/

import java.util.*;

public class partitionList{
    
    public static void generate(ListNode h, int x){
        // this kind of problem is tricky when only maintain one list
        ListNode leftdummy= new ListNode(-1);
        ListNode rightdummy= new ListNode(-2);
        ListNode left=leftdummy, right= rightdummy;
        while (h != null){
            if ( h.val < x ){
                left.next= h;
                left= left.next;
            }else {
                right.next= h;
                right = right.next;
            }
            h= h.next;
        }
        left.next=rightdummy.next;
        right.next= null;
        
        leftdummy.next.printList();
    }
    
    public static void main(String[] args){
        int[] arr= {1, 4, 3, 1, 2, 5, 7, 8, 5, 3, 2};
        ListNode h= new ListNode(arr);
        h.printList();
        generate(h, 5);
    }
    
}

/* given a circular linked list, returns the node at the beginning of the loop
*/
import java.util.*;

public class linkedListCircle{
    
    public static void helper(ListNode h){
       /* ListNode fast= h.next.next, slow= h.next;// init is important
        
        while(fast != slow){
            fast= fast.next.next;
            slow= slow.next;
        }*/
        ListNode fast= h, slow = h;
        do{
            if(fast== null || slow== null)
                return;
            fast= fast.next.next;
            slow= slow.next;
            
        }while(fast != slow);
        
        fast= h;
        while(fast != slow){
            fast= fast.next;
            slow= slow.next;
        }
    
        System.out.println(fast.val);
    }
    
    public static void main(String[] args){
        int[] arr= {1, 4, 3, 10, 2, 5, 7, 8, 5, 3, 2};
        ListNode h= new ListNode(arr);
        ListNode cur= h;
        while(cur.next!= null){
            cur= cur.next;
        }
        cur.next= h.next.next.next;
        helper(h);
        
    }
    
}
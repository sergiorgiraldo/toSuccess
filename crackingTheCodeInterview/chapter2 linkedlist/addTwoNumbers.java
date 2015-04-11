  /**
    * Two numbers represented by a linked list in forward order
    * Add the two numbers and return the sum as a linked list
    * eg, A = 1->3->2, B = 8->2
    * Sum = 2->1->4
    */

import java.util.*;

public class addTwoNumbers{
    // reverse both lists -> Leetcode/AddTwoNumbers-> reverse the result
    // time: O(n); space:O(n), n is the length of the result list
    public static void add(ListNode n1, ListNode n2){
        ListNode n1r= reverse(n1);
        ListNode n2r= reverse(n2);
        ListNode dummy= new ListNode(-1);
        
        ListNode point1= n1r, point2= n2r, cur= dummy;
        int carry=0;
        
        while(point1 != null  && point2 != null){
            int value = point1.val+ point2.val + carry;
            if(value >=10){
                value-= 10;
                carry= 1;
            }else{
                carry=0;
            }
            cur.next= new ListNode(value);
            
            cur= cur.next;
            point1= point1.next;
            point2= point2.next;
        }
        
        while(point1 != null){
            int value= point1.val+ carry;
            if(value >=10){
                value-= 10;
                carry= 1;
            }else{
                carry=0;
            }
            cur.next= new ListNode(value);
            
            cur= cur.next;
            point1= point1.next;
        }
        
        while(point2 != null){
            int value= point2.val+ carry;
            if(value >=10){
                value-= 10;
                carry= 1;
            }else{
                carry=0;
            }
            cur.next= new ListNode(value);
            
            cur= cur.next;
            point2= point2.next;
        }
        
        if(carry !=0)
        	cur.next= new ListNode(carry);
        
        dummy = reverse(dummy.next);
        dummy.printList();
    }
    
    public static ListNode reverse(ListNode h){
        ListNode dummy= new ListNode(-1);
        
        while(h !=null){
            ListNode tmp=new ListNode(h.val); // must allocate
            tmp.next= dummy.next;
            dummy.next= tmp;
            
            h= h.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args){
        int[] n1= {9, 2, 3, 8, 9};
        int[] n2= {1, 6, 7, 9};
        ListNode h1= new ListNode(n1);
        ListNode h2= new ListNode(n2);
        ListNode t= reverse(h1);
        
        add(h1, h2);
    }
}
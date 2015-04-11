/**
    * Implement an algorithm to find the kth to last element of a singly linked list
    * Note: assume k is always valid
*/
   
import java.util.*;

public class findKthNodeFromTheEnd{
    
    public static void helper(ListNode h, int k){
        int len= h.getLength();
        if(k > len) return;
    
        ListNode cur= h;
        int count= len - k;
        while(count > 0){
            cur= cur.next;
            count--;
        }
        System.out.println(cur.val);
    }
    
    public static void main(String[] args){
        int[] arr= {1, 4, 3, 1, 2, 5, 7, 8, 3, 2};
        ListNode h= new ListNode(arr);
        h.printList();
        
        helper(h, 3);
        
    }
    
}
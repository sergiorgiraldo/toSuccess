/* implement a function to check if a linked list is a palindrome
*/

import java.util.*;

public class palindromeList{
    
    // reverse and compare,  O(n) + O(n)
    public static void helper(ListNode h){
        ListNode rev= reverse(h);
        ListNode p1= h, p2= rev;
        while(p1 != null  && p2 != null){
            if(p1.val != p2.val){
                System.out.println(false);
                return;
            }
            p1= p1.next;
            p2= p2.next;
        }
        
        System.out.println(true);
    }
    
    public static ListNode reverse(ListNode h){
        
        ListNode dummy= new ListNode(-1);
        
        while (h != null){
            ListNode tmp= new ListNode(h.val);
            tmp.next= dummy.next;
            dummy.next= tmp;
            h= h.next;
        }
        return dummy.next;
    }
    
    // stack left part and compare with the right part
    public static void helper2(ListNode h){
        int len= h.getLength();
        int n= len/2;
        Stack<Integer> s= new Stack<Integer>();
        while(n >0 ){
            s.push(h.val);
            h= h.next;
            n--;
        }
        if(len %2!=0){
            h= h.next;
        }
        while(h != null){
            if(h.val != s.peek()){
                System.out.println(false);
                return;
            }else{
                s.pop();
                h= h.next;
            }
        }
        System.out.println(true);
    }
    
    public static void main(String[] args){
        
        //int[] arr= {1, 4, 3, 10, 2, 2, 10, 3, 4, 1};
        int[] arr= {1, 4, 3, 10,  6, 10, 3, 4, 1};
        ListNode h= new ListNode(arr);
        helper2(h);
    }
    
}
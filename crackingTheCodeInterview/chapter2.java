
public class chapter2{

    /* write code to remove duplicates from an unsorted linked list,  How would you solve this problem if a temporary buffer is not allowed*/
    public static void problem2_1(){
    
        
    
    }

    /* Implement an algorithm to find the kth to last element of a singly linked list*/
    public static void problem2_2(){
        
        
    }
    
    /* Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node */
    public static void problem2_3(){
        
        
    }
    
    /* write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x */
    public static void problem2_4(){
        
        
    }
    
    /* you have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit id at the head of the list, write a function that adds the two numbers and returns the sum as a linked list*/
    public static void problem2_5(){
        
        
    }
    
    /* Given a circular linked list, implement an algorithm which returns the node at the begining of the loop*/
    public static void problem2_6(){
        
        
    }
    
    /* Implement a function to check if a linked list is a palindrome */
    public static void problem2_7(){
        
        
    }
    
    public static void printlist(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.print("\n");
    
    }
    
    public static void main(String[] args){
        ListNode h=new ListNode(0);
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        h.next=n1;
        printlist(h);
    }



}
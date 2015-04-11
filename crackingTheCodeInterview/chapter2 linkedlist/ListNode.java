public class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    
    public ListNode(int[] arr){
        if(arr.length <= 0)
            return;
        this.val= arr[0];
        ListNode head= this, prev = this;
        for(int i=1; i< arr.length; ++i ){
            head.next= new ListNode(arr[i]);
            prev= head;
            head= head.next;
        }
    }
    
    public void printList(){
        ListNode head= this;
        while(head != null){
            System.out.print(head.val+" ");
            head= head.next;
        }
        System.out.println();
    }
    
    public int getLength(){
        int len=0;
        ListNode head= this;
        while(head != null){
            head= head.next;
            len++;
        }
        return len;
    }
    
}

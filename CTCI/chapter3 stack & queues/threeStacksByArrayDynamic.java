/**
    * Describe how you could use a single array to implement three stacks
 */
import java.util.*;

/*In this approach, any stack can grow as long as there is any free space in the array.
We sequentially allocate space to the stacks and we link new blocks to the previous block. 
This means any new element in a stack keeps a pointer to the previous top element of that particular stack.

if a stack deletes some of its elements, the deleted elements may not necessarily appear at the end of the array. 

we can maintain a free list and the whole array space would be given initially to the free list. 
For every insertion, we would delete an entry from the free list. In case of deletion, 
we would simply add the index of the free cell to the free list.

*/
public class threeStacksByArrayDynamic{
    
    class Node{
        int prev; // record prevous's node index
        int val;
        public Node(int val){
            this.val= val;
        }
    }

    int [] top= new int[3];
    Node arr[];
    //int cursize;
    ArrayList<Integer> freelist= new ArrayList<Integer>();

    public threeStacksByArrayDynamic(int size){
        arr= new Node[size];
        for(int i=0; i< size; ++i)
            freelist.add(i);
        for(int i=0; i<3; ++i)
            top[i]=-1;
    }

    public void push(int stacknum, int val){
        if(isFull()){
            throw new IllegalArgumentException(stacknum + " is full");
        }
        Node node= new Node(val);   
        node.prev= top[stacknum];
        arr[freelist.get(0)]= node;
        top[stacknum] =freelist.get(0);
        freelist.remove(0);
    }

    public void pop(int stacknum){
        if(isEmpty(stacknum)){
            throw new IllegalArgumentException(stacknum + " is empty");
        }
        Node node= arr[top[stacknum]];
        freelist.add(top[stacknum]);
        arr[top[stacknum]]= null;
        top[stacknum] = node.prev;
        //node.prev= -1;
        //System.out.println(node.val);
    }

    public boolean isEmpty(int stacknum){
        
        return top[stacknum]==-1;
    }
    
    public boolean isFull(){
        
        return freelist.size()== 0;
    }
    
    public void peek(int stacknum){
        if(isEmpty(stacknum)){
            throw new IllegalArgumentException(stacknum + " is empty");
        }
        Node node= arr[top[stacknum]];
       // System.out.println(node.val);
    }
    
    public String toString(int stacknum){
        StringBuilder res= new StringBuilder();
        Node node= arr[top[stacknum]];
        while(node.prev!=-1){
            res.append(node.val+ " ");
            node= arr[node.prev];
        }
        res.append(node.val);
        return res.toString();
    }
    public static void main(String [] args){
        threeStacksByArrayDynamic s= new threeStacksByArrayDynamic(12);
        for(int i=0; i<4; ++i){
            s.push(0, i);
            s.push(1, i+4);
            s.push(2, i+8);
        }
        System.out.println(s.toString(0));
        System.out.println(s.toString(1));
        System.out.println(s.toString(2));
        for(int i=0; i<2; ++i){
            s.pop(0);
    
            s.pop(1);
    
            s.pop(2);
        }
        System.out.println(s.toString(0));
        System.out.println(s.toString(1));
        System.out.println(s.toString(2));
        
        for(int i=0; i<2; ++i){
            s.push(0, 111);
            s.push(1, 222);
            s.push(2, 333);
        }
        System.out.println(s.toString(0));
        System.out.println(s.toString(1));
        System.out.println(s.toString(2));
    }
}
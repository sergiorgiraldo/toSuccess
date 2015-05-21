/*
implement hashset from scratch
reference: big java chapter 16
*/
public class myHashSet extends AbstractSet{
    class Node{
        Object data;
        Node next;
        public Node(Object data){
            this.data= data;
            next= null;
        }
    }
    
    class hashsetIterator implements Iterator{
        private Node next;
        private Node cur;
        
        public hashsetIterator(){
              cur= null;
              next= bucket[0];// how to init in inner class ?
            
        }
        
        public boolean hasNext(){
            return next==null;
        }
        
        public Object next(){
            if(!hasNext())
                return null;
            cur= next;
            next= next.next;
            return cur;
        }
    
    }
    
    private Node[] bucket;
    private int size;
    private DEFAULT_CAPACITY=16;
    
    public myHashSet(){
        size=0;
        bucket= new Node[DEFAULT_CAPACITY];
    };
    
    public boolean add(Object obj){
        int h= obj.hashCode()%bucket.length;
        
        Node newnode= new Node(obj);
        if(bucket[h]==null){
            bucket[h]= newnode;
        }else{
            Node current= bucket[h];
            while(current!= null){
                if(current.data.equals(obj))
                    return false;
                current= current.next;
            }
            
            current.next= newnode;
        }
        size++;
        return true;
    }
    
    public boolean remove(Object obj){
        int h= obj.hashCode()%bucket.length;
        
        Node cur= bucket[h];
        Node prev=null;
        while(cur!= null){
            if(cur.data.equals(obj)){
                if(prev==null){// obj at the head, only one obj
                    cur=null;
                }else{
                    prev.next= cur.next;
                    cur.next= null;
                }
                size--;
                return true;
            }
            prev= cur;
            cur= cur.next;
        }
        return false;
    }
    
    public boolean contains(Object obj){
        int h= obj.hashCode()%bucket.length;
        Node cur= bucket[h];
        while(cur!=null){
            if(cur.data.equals(obj))
                return true;
            cur= cur.next;
        }
        return false;
    }
    
    public Iterator iterator(){
        return new hashsetIterator();
    }
    
    public int size(){
        return size;
    }

}
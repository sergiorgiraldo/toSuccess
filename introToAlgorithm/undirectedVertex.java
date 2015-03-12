import java.util.*;
// using adjscent-list
public class undirectedVertex{
    String name;
    LinkedList<undirectedVertex> neighbors= new LinkedList<undirectedVertex>();
    
    public undirectedVertex(String name){
        this.name=name;
    }
    
    public void addEdge(undirectedVertex v){
        neighbors.add(v);
        v.neighbors.add(this);
    }

}

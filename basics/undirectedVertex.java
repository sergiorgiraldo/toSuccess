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

/*
 Representation of Graphs:
 
 1 adjacency-list
   -prefered for sparse grahs, those for which |E| < |V| ^2
   
 
 2 adjacency-matrix
   -dense
   -need to tell quickly if there is an edge connecting two given vertices.
 
 */
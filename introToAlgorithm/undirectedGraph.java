import java.util.*;
//package util;
             
public class undirectedGraph{
    
    private static ArrayList<undirectedVertex> allNodes = new ArrayList<undirectedVertex>();
    
    public static void bfs(undirectedVertex s){
        ArrayList<undirectedVertex> visited = new ArrayList<undirectedVertex>();
        Queue<undirectedVertex> q= new LinkedList<undirectedVertex>();
        q.add(s);
        visited.add(s);
        System.out.println("bfs "+ s.name);
        while(!q.isEmpty()){
            undirectedVertex cur= q.poll();
            for(undirectedVertex v: cur.neighbors){
                if(!visited.contains(v)){
                    q.add(v);
                    System.out.println("bfs "+ v.name);
                    visited.add(v);
                }
            }
        }
    }
    
    public static void dfs(undirectedVertex s){
        ArrayList<undirectedVertex> visited = new ArrayList<undirectedVertex>();
        Stack<undirectedVertex> mystack= new Stack<undirectedVertex>();
        mystack.push(s);
        
        while(!mystack.isEmpty()){
            undirectedVertex cur= mystack.pop();
            if(!visited.contains(cur)){
                System.out.println("dfs "+ cur.name);
                visited.add(cur);
                for(undirectedVertex v: cur.neighbors)
                    mystack.push(v);
            }
        }
        
    }
    
    public static void main(String[] args){
        undirectedVertex v1= new undirectedVertex("a");
        undirectedVertex v2= new undirectedVertex("b");
        undirectedVertex v3= new undirectedVertex("c");
        undirectedVertex v4= new undirectedVertex("d");
        undirectedVertex v5= new undirectedVertex("e");
        undirectedVertex v6= new undirectedVertex("f");
        undirectedVertex v7= new undirectedVertex("g");
        undirectedVertex v8= new undirectedVertex("h");
        
        v1.addEdge(v2);
        v1.addEdge(v3);
        v1.addEdge(v4);
        v2.addEdge(v5);
        v3.addEdge(v6);
        v3.addEdge(v7);
        v5.addEdge(v8);
        
        allNodes.add(v1);
        allNodes.add(v2);
        allNodes.add(v3);
        allNodes.add(v4);
        allNodes.add(v5);
        allNodes.add(v6);
        allNodes.add(v7);
        allNodes.add(v8);
        
        dfs(v3);
        System.out.println("-------------- ");
        bfs(v3);
    
    }
    
}
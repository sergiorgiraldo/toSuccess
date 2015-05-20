/*
Given a directed graph, design an algorithm to find out whether there is a route be- tween two nodes
*/

import java.util.*;

class GraphNode{
    int val;
    ArrayList<GraphNode> neighboars;
    public GraphNode(int val){
        this.val = val;
        neighboars= new ArrayList<GraphNode>();
    }

    public void add(GraphNode n){
        if( n== null)
            return;
        neighboars.add(n);
    }
}

class graphConnectivity{

    // here dfs and bfs almost the same : it's find the path between two nodes.
    // while traverse graph, they are not the same (they are trying to find all nodes). 
    public static void dfs(GraphNode a, GraphNode b){
        boolean found= false;
        Stack<GraphNode> s= new Stack<GraphNode>();
        HashSet<GraphNode> visited= new HashSet<GraphNode>();
        s.add(a);
        while(!s.isEmpty()){
            GraphNode cur= s.pop();
            if(cur== b){
                System.out.println("visiting: " + cur.val);
                found= true;
                break;
            }else{
                if(visited.contains(cur))
                    continue;
                else{
                    System.out.println("visiting: " + cur.val);
                    for(GraphNode n: cur.neighboars){
                        s.push(n);
                    }
                }
            }
        }
        if(found)
            System.out.println("found !");
        else
            System.out.println("not found !");
    
    }
    
    public static void main(String[] args){
        
        GraphNode n1= new GraphNode(1);
        GraphNode n2= new GraphNode(2);
        GraphNode n3= new GraphNode(3);
        GraphNode n4= new GraphNode(4);
        GraphNode n5= new GraphNode(5);
        
        n1.add(n4);
        n1.add(n3);
        n2.add(n1);
        n2.add(n3);
        n4.add(n2);
        n4.add(n5);
        
        dfs(n2, n5);
        dfs(n3, n5);
        
    }



}
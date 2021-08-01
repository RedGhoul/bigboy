package com.JavaAlgos.Colt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GraphDFS_BFS {
    public static void main(String[] args){
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("B","D");
        g.addEdge("C","E");
        g.addEdge("D","E");
        g.addEdge("D","F");
        g.addEdge("E","F");

        System.out.println(Arrays.toString(DFS_R("A",g).toArray()));
    }

    public static ArrayList<String> DFS_R(String Vertex, Graph g){
        ArrayList<String> resultsList = new ArrayList<>();
        HashMap<String,Boolean> Seen = new HashMap<>();
        DFS_R_Helper(g,Vertex,resultsList,Seen);
        return resultsList;
    }

    public static void DFS_R_Helper(Graph g,String Vertex,ArrayList<String> resultsList,HashMap<String,Boolean> Seen ){
        ArrayList<String> curNs = g.AJList.get(Vertex);
        if(curNs.size() == 0) return;
        resultsList.add(Vertex);
        Seen.put(Vertex, true);
        for(String value : curNs){
            if (!Seen.containsKey(value)){
                DFS_R_Helper(g,value,resultsList,Seen);
            }
        }
        //return;
    }
}

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
        System.out.println(Arrays.toString(DFS_Iterative("A",g).toArray()));
        System.out.println(Arrays.toString(BFS_Iterative("A",g).toArray()));
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

    public static ArrayList<String> DFS_Iterative(String vertex, Graph g){
        HashMap<String,Boolean> seenList = new HashMap<>();
        ArrayList<String> Stack = new ArrayList<>();
        Stack.add(vertex);
        seenList.put(vertex,true);
        ArrayList<String> Result = new ArrayList<>();
        while(Stack.size() >0){
            String curVertex = Stack.remove(Stack.size()-1);
            Result.add(curVertex);

            ArrayList<String> childNodes = g.AJList.get(curVertex);
            for (String node: childNodes) {
                if(!seenList.containsKey(node)){
                    seenList.put(node,true); // if you don't do this then its children are going to be added twice
                    Stack.add(node);
                }
            }
        }
        return Result;
    }

    public static ArrayList<String> BFS_Iterative(String vertex, Graph g){
        HashMap<String,Boolean> seenList = new HashMap<>();
        ArrayList<String> Stack = new ArrayList<>();
        Stack.add(vertex);
        seenList.put(vertex,true);
        ArrayList<String> Result = new ArrayList<>();
        while(Stack.size() >0){
            String curVertex = Stack.remove(0);
            Result.add(curVertex);

            ArrayList<String> childNodes = g.AJList.get(curVertex);
            for (String node: childNodes) {
                if(!seenList.containsKey(node)){
                    seenList.put(node,true); // if you don't do this then its children are going to be added twice
                    Stack.add(node);
                }
            }
        }
        return Result;
    }
}

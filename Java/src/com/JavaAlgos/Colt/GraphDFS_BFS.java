package com.JavaAlgos.Colt;

import com.JavaAlgos.LeetCode.Top100.Medium.GroupAnagrams;
import com.JavaAlgos.LeetCode.Top100.Medium.QuadrupleSumToTarget;

import java.util.*;

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

       // System.out.println(Arrays.toString(DFS_R("A",g).toArray()));
       System.out.println(Arrays.toString(DFS_Iterative("A",g).toArray()));
       System.out.println(Arrays.toString(BFS_Iterative("A",g).toArray()));
    }

    /**
     * Same thing we always thought
     * First come, first served, first child of the current node.
     * Aka keep going deep as possible, till you can't anymore
     *
     * In this case it lends its self well to Recursion
     *
     * I am guessing in the interative approcae for DFS we keep adding more things infornt
     * Aka use a stack, if not allowed to use recursion
     * **/
    public static List<String> DFS_R(String Node, Graph g){
        List<String> output = new ArrayList<>();
        HashMap<String, Boolean> bag = new HashMap<>();
        output.add(Node);
        bag.put(Node,true);
        Re_Helper(Node, g, output,bag);
        return output;
    }

    public static void Re_Helper(String curNode, Graph g, List<String> output, HashMap<String,Boolean> bag){
        List<String> Childern = g.AJList.get(curNode);

        for(String child : Childern){
            if(!bag.containsKey(child)){
                bag.put(child,true);
                output.add(child);
                Re_Helper(child,g,output, bag);
            }
        }
    }

    public static List<String> DFS_Iterative(String Node, Graph g){
        List<String> output = new ArrayList<>();
        HashMap<String, Boolean> bag = new HashMap<>();
        Stack<String> stack = new Stack<>();
        stack.add(Node);
        bag.put(Node, true);
        while(!stack.isEmpty()){
            String currentNode = stack.pop();
            output.add(currentNode);
            List<String> childern = g.AJList.get(currentNode);
            for(int i = 0; i < childern.size(); i++){
                String IterChild = childern.get(i);
                if(!bag.containsKey(IterChild)){
                    bag.put(IterChild,true);
                    stack.add(IterChild);
                }
            }
        }
        return output;
    }

    public static List<String> BFS_Iterative(String Node, Graph g){
        List<String> output = new ArrayList<>();
        HashMap<String,Boolean> hashMap = new HashMap<>();
        hashMap.put(Node,true);
        Queue<String> qq = new LinkedList<>();
        qq.add(Node);
        while(!qq.isEmpty()){
            String currentNode = qq.poll();
            output.add(currentNode);

            List<String> childern = g.AJList.get(currentNode);
            for(String node: childern){
                if(!hashMap.containsKey(node)){
                    hashMap.put(node, true);
                    qq.add(node);
                }
            }
        }
        return output;
    }

}

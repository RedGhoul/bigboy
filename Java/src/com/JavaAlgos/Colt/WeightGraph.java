package com.JavaAlgos.Colt;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightGraph {
    public HashMap<String, ArrayList<WGConnection>> adjacencyList;

    public WeightGraph(){
        adjacencyList = new HashMap<String, ArrayList<WGConnection>>();
    }

    public void addEdge(String vertex1, String vertex2, Integer weight){
        if(vertex1.isEmpty() || vertex2.isEmpty()) return;
        if(this.adjacencyList.containsKey(vertex1)){
            ArrayList<WGConnection> listV = this.adjacencyList.get(vertex1);
            if(!listV.contains(new WGConnection(vertex2,weight))){
                listV.add(new WGConnection(vertex2,weight));
            }
        }
        if(this.adjacencyList.containsKey(vertex2)){
            ArrayList<WGConnection> listV = this.adjacencyList.get(vertex2);
            if(!listV.contains(new WGConnection(vertex1,weight))){
                listV.add(new WGConnection(vertex1,weight));
            }
        }
    }
}

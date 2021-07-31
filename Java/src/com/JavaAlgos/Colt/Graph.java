package com.JavaAlgos.Colt;
import java.util.*;

public class Graph {
    private HashMap<String,ArrayList<String>> AJList;
    public Graph(){
        AJList = new HashMap<>();
    }
    public static void main(String[] args){

    }

    public void addVertex(String vertexName){
        if(!this.AJList.containsKey(vertexName)){
            this.AJList.put(vertexName, new ArrayList<>());
        }

    }
    public void addVertex_Force(String vertexName){
        this.AJList.put(vertexName, new ArrayList<>());
    }

    public void addEdge(String vertexA, String vertexB){
        if(!this.AJList.containsKey(vertexA) || !this.AJList.containsKey(vertexB)){
            return;
        }
        List<String> vertexAList = this.AJList.get(vertexA);
        if(!vertexAList.contains(vertexB)){
            vertexAList.add(vertexB);
        }

        List<String> vertexBList = this.AJList.get(vertexB);
        if(!vertexBList.contains(vertexA)){
            vertexBList.add(vertexA);
        }
    }

    public void removeEdge(String vertexA, String vertexB){
        if(!this.AJList.containsKey(vertexA) || !this.AJList.containsKey(vertexB)){
            return;
        }
        List<String> vertexAList = this.AJList.get(vertexA);
        if(vertexAList.contains(vertexB)){
            vertexAList.remove(vertexB);
        }

        List<String> vertexBList = this.AJList.get(vertexB);
        if(vertexBList.contains(vertexA)){
            vertexBList.remove(vertexA);
        }
    }

    public void removeVertex(String vertexA){
        if(!this.AJList.containsKey(vertexA)){
            return;
        }

        this.AJList.remove(vertexA);

        for(Map.Entry<String, ArrayList<String>> entry : this.AJList.entrySet()){
            if(entry.getValue().contains(vertexA)){
                entry.getValue().remove(vertexA);
            }
        }

    }
}

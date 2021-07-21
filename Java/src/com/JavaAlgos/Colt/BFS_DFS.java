package com.JavaAlgos.Colt;

import java.util.ArrayList;
import java.util.Arrays;

public class BFS_DFS {
    public static void main(String[] args){
        BSTNode root = new BSTNode(10);
        BSTNode left1 = new BSTNode(6);
        BSTNode right1 = new BSTNode(15);
        BSTNode left2 = new BSTNode(3);
        BSTNode right2 = new BSTNode(8);
        BSTNode right3 = new BSTNode(20);
        root.right = right1;
        root.left = left1;
        right1.right = right3;
        left1.left = left2;
        left1.right = right2;
        System.out.println(Arrays.toString(BFS(root).toArray()));
        System.out.println(Arrays.toString(DFS_PreOrder(root).toArray()));
    }

    // the iterative approach
    public static ArrayList<Integer> BFS(BSTNode input){
        if(input == null) return null;
        ArrayList<BSTNode> qq = new ArrayList<>();
        qq.add(input);
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(qq.size() >0){
            BSTNode cur = qq.remove(0);
            finalArr.add(cur.value);
            if(cur.left != null){
                qq.add(cur.left);
            }
            if(cur.right != null){
                qq.add(cur.right);
            }
        }
        return finalArr;
    }
    /*
    * Did this in the recursive way. But you could have also done this in the
    * interactive way as well. Where instead of putting the nodes on the back of the queue
    * you, put the latest nodes on the front of the queue.
    * And then read off of that queue.
    * */
    public static ArrayList<Integer> DFS_PreOrder(BSTNode input){
        if(input == null) return null;
        ArrayList<Integer> finalArr = new ArrayList<>();
        DFS_PreOrderHelper(finalArr,input);
        return finalArr;
    }

    public static void DFS_PreOrderHelper(ArrayList<Integer> finalArr, BSTNode node){
        finalArr.add(node.value);
        if(node.left != null){
            DFS_PreOrderHelper(finalArr,node.left);
        }
        if(node.right != null){
            DFS_PreOrderHelper(finalArr,node.right);
        }
    }

}

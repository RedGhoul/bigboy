package com.JavaAlgos.Colt;

public class NaiveStringSearch {
    public static void main(String[] args){
        System.out.println(Find("enter Firewall to  or leave a Droplet. ","z"));

    }

    public static boolean Find(String bigString, String smallString){
        if(smallString == null || bigString == null ||
                smallString.length() > bigString.length()){
            return false;
        }
        int curPoint = 0;
        for(int i = 0; i < bigString.length(); i++){
            String curValue = String.valueOf(bigString.charAt(i));
            String smallValue = String.valueOf(smallString.charAt(curPoint));
            if(curPoint == smallString.length()-1 && curValue.equals(smallValue)){
                return true;
            }else if (curValue.equals(smallValue)){
                curPoint++;
            }else {
                curPoint = 0;
            }
        }
        return false;
    }
}

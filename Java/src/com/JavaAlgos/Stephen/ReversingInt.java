package com.JavaAlgos.Stephen;

//section 5
public class ReversingInt {
    public static void main (String[] args){
        System.out.println(RevereInt(821215));
        System.out.println(RevereInt(55555559));
        System.out.println(RevereInt(53429));
        System.out.println(RevereInt(-53));
        System.out.println(RevereInt(-15));
    }

    // building another string way
    // keep in mind negatives
    // -15 => -51
    public static String RevereInt(int input){
        Integer newInt = input;

        String newIntString = newInt.toString();
        String output = "";

        for(int i = newIntString.length()-1; i >= 0; i--){
            output = output + newIntString.charAt(i);
        }

        if(output.charAt(output.length()-1) == '-'){
            output = "-" + output.substring(0,output.length()-1);
            // the last index in the substring is not included
            // instead of 2 you just have to say 1
        }

        return output;
    }
}

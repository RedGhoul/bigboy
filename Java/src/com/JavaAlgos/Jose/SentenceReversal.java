package com.JavaAlgos.Jose;

public class SentenceReversal {
    /**
     * I think you can approach this as the standard sort of reversal program.
     *
     * Convert string to char array. Then use the double pointer method to swap.
     * Nope that won't work since if you did that everything would be backwards
     *
     * You have swap word by word.
     *
     * So you would have to break the sentence word by word then add it together
     * in reverse, to form a new sentence.
     * */

    public static void main(String[] args){
        System.out.println(getReversal("This is the best"));
    }

    public static String getReversal(String input){
        if(input == null || input.isEmpty()) return null;

        String[] wordArray = input.split(" ");
        int p1 = 0;
        int p2 = wordArray.length-1;
        while(p1<p2){
            String temp = wordArray[p1];
            wordArray[p1] = wordArray[p2];
            wordArray[p2] = temp;
            p1++;
            p2--;
        }
        //String.join() !
        return String.join(" ",wordArray);
    }
}

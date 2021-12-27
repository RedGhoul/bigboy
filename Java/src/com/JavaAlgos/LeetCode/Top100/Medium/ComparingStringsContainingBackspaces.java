package com.JavaAlgos.LeetCode.Top100.Medium;

public class ComparingStringsContainingBackspaces {

    /**
     * Comparing Strings containing Backspaces (medium)#
     * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
     * <p>
     * Example 1:
     * <p>
     * Input: str1="xy#z", str2="xzz#"
     * Output: true
     * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
     * Example 2:
     * <p>
     * Input: str1="xy#z", str2="xyz#"
     * Output: false
     * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
     * Example 3:
     * <p>
     * Input: str1="xp#", str2="xyz##"
     * Output: true
     * Explanation: After applying backspaces the strings become "x" and "x" respectively.
     * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
     * Example 4:
     * <p>
     * Input: str1="xywrrmp", str2="xywrrmu#p"
     * Output: true
     * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
     * <p>
     * When they say "Backspaces" they mean deletes
     * so xy#z means -> xz since y gets deleted
     * <p>
     * What I am thinking:
     * You have to compare the end result, when all the deletions are done right ?
     * <p>
     * Double pointers since this is a double pointer problem
     * <p>
     * P1 points to index 0 of first String
     * P2 points to index 0 of second String
     * <p>
     * The most straight forward way is to make the deletions on each string
     * then test if they are equal
     * <p>
     * After:
     * Your first instincts were right, double pointers each pointer points to the two diff strings
     * And you would have some sort of while loop going on in which
     * you compared the two strings piece by piece
     * <p>
     * Time: O(n + m) length of both the first and second string. Worst case you go all the way near
     * the end of 1, and then you stop and go alll the way near the end of the other
     * Space: O(1) finite space, not creating a new array to store anything
     **/
    public static void main(String[] args) {

    }


    public static boolean compare(String str1, String str2) {
        int p1 = str1.length() - 1;
        int p2 = str2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            p1 = getValidVal(str1, p1);
            p2 = getValidVal(str2, p2);
            /**
             * Got most of it right, but forgot about the invalid / valid cases
             * of the indexes.
             *
             * When they are both at the end
             *
             * When only one of them is at the end
             * **/
            if (p1 <= 0 && p2 <= 0) return true;
            if (p2 <= 0 || p2 <= 0) return false;

            char cur1Val = str1.charAt(p1);
            char cur2Val = str2.charAt(p2);

            if (cur1Val != cur2Val) {
                return false;
            }
            /**
             * Also forgot to increment the indexes at the very end
             * **/
            p1 = p1 - 1;
            p2 = p2 - 1;
        }

        return true;
    }

    public static int getValidVal(String curString, int index) {
        char curVal = curString.charAt(index);
        int count = 0;
        while (curVal == '#') {
            index--;
            count++;
            curVal = curString.charAt(index);
        }
        index = index - count;
        return index;
    }

    // other way of doing the above
    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') // found a backspace character
                backspaceCount++;
            else if (backspaceCount > 0) // a non-backspace character
                backspaceCount--;
            else
                break;

            index--; // skip a backspace or a valid character
        }
        return index;
    }

}

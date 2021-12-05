package com.JavaAlgos.AlgoMonster;

public class FindSmallestLetterGreaterThanTarget {
    /**
     * Given a characters array "letters" that is sorted in non-decreasing order and a character target,
     * return the smallest character in the array that is larger than target.
     * <p>
     * Note that the letters wrap around.
     * <p>
     * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: letters = ["c","f","j"], target = "a"
     * Output: "c"
     * Example 2:
     * <p>
     * Input: letters = ["c","f","j"], target = "c"
     * Output: "f"
     * Example 3:
     * <p>
     * Input: letters = ["c","f","j"], target = "d"
     * Output: "f"
     * Example 4:
     * <p>
     * Input: letters = ["c","f","j"], target = "g"
     * Output: "j"
     * Example 5:
     * <p>
     * Input: letters = ["c","f","j"], target = "j"
     * Output: "c"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= letters.length <= 104
     * letters[i] is a lowercase English letter.
     * letters is sorted in non-decreasing order.
     * letters contains at least two different characters.
     * target is a lowercase English letter.
     * <p>
     * Has a time complexity of O(Log(N)) massive diff vs O(N)
     * Whereas if we just did the standard for loop we would have, hmmmm
     * could we have do this with a for loop, I feel like it would have been a lot harder
     **/

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int one_over = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            char curVal = letters[mid];
            if (curVal > target) {
                one_over = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[one_over];
    }
}

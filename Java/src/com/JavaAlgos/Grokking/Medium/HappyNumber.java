package com.JavaAlgos.Grokking.Medium;

public class HappyNumber {
    /**
     * PATTERN: FAST SLOW POINTERS
     * Problem Statement#
     * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of
     * the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
     * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
     *
     * Example 1:
     *
     * Input: 23
     * Output: true (23 is a happy number)
     * Explanations: Here are the steps to find out that 23 is a happy number:
     * 2^2 + 3 ^22
     * ​2
     * ​​ +3
     * ​2
     * ​​  = 4 + 9 = 13
     * 1^2 + 3^21
     * ​2
     * ​​ +3
     * ​2
     * ​​  = 1 + 9 = 10
     * 1^2 + 0^21
     * ​2
     * ​​ +0
     * ​2
     * ​​  = 1 + 0 = 1
     * Example 2:
     *
     * Input: 12
     * Output: false (12 is not a happy number)
     * Explanations: Here are the steps to find out that 12 is not a happy number:
     * 1^2 + 2 ^21
     * ​2
     * ​​ +2
     * ​2
     * ​​  = 1 + 4 = 5
     * 5^25
     * ​2
     * ​​  = 25
     * 2^2 + 5^22
     * ​2
     * ​​ +5
     * ​2
     * ​​  = 4 + 25 = 29
     * 2^2 + 9^22
     * ​2
     * ​​ +9
     * ​2
     * ​​  = 4 + 81 = 85
     * 8^2 + 5^28
     * ​2
     * ​​ +5
     * ​2
     * ​​  = 64 + 25 = 89
     * 8^2 + 9^28
     * ​2
     * ​​ +9
     * ​2
     * ​​  = 64 + 81 = 145
     * 1^2 + 4^2 + 5^21
     * ​2
     * ​​ +4
     * ​2
     * ​​ +5
     * ​2
     * ​​  = 1 + 16 + 25 = 42
     * 4^2 + 2^24
     * ​2
     * ​​ +2
     * ​2
     * ​​  = 16 + 4 = 20
     * 2^2 + 0^22
     * ​2
     * ​​ +0
     * ​2
     * ​​  = 4 + 0 = 4
     * 4^24
     * ​2
     * ​​  = 16
     * 1^2 + 6^21
     * ​2
     * ​​ +6
     * ​2
     * ​​  = 1 + 36 = 37
     * 3^2 + 7^23
     * ​2
     * ​​ +7
     * ​2
     * ​​  = 9 + 49 = 58
     * 5^2 + 8^25
     * ​2
     * ​​ +8
     * ​2
     * ​​  = 25 + 64 = 89
     * Step ‘13’ leads us back to step ‘5’ as the number becomes equal to ‘89’, this means that we can never reach ‘1’, therefore, ‘12’ is not a happy number.
     *
     *
     * What I am thinking:
     * 1) Get the digits in the number given.
     * 2) Iterate over the digits and square them, and keep a running sum
     * 3) If the final sum you get in step 2 is not equal to 0 then
     * repeat steps 1 -> 2
     * *) Also keep a seen map, where you can tell if you have gotten the same
     * sum before, so you know when to stop
     *
     * What was actually the solution:
     * It used the same sort of thinking as what you originally thought.
     * In the sense you can only find a cycle if you see the same thing twice.
     *
     * Except they really take the fast / slow pointer thing pretty seriously. Instead of using
     * as hashmap. So they do exactly that, in the sense the fist pointer points to the
     * numbers square of its sum of numbers. Whereas the second pointer points is just the same
     * thing as the first pointer but called twice (as in moved two, as in the first pointer)
     *
     * I think your idea would have worked as well
     *
     * Time complexity:
     * Is pretty out there, they link to a wiki article
     * But long story short
     * N = number
     * M = number of digits in N
     * N1 < 9^2M
     * M = log(N+1)
     * N1 < 81 * Log(N+1)
     * So basically it becomes O(Log(n))
     *
     * Space Complexity:
     * Pretty simple we aren't making a lot of new things and storing them.
     * So its going to be O(1)
     * **/

    public static boolean find(int num) {
        int fast = num;
        int slow = num;
        // they are both equal initially so this wouldn't make a lot of sense.
        // so have to do it above once
        fast = findSquareSum(findSquareSum(fast));
        slow = findSquareSum(slow);

        while(fast != slow){
            fast = findSquareSum(findSquareSum(fast));
            slow = findSquareSum(slow);
        }
        // don't need to do anything in "while" since the case where it won't equal to 1
        // is accounted for. And eventually it will break out of the loop since fast and slow
        // will eventually point to the same thing which, might not be 1
        return slow == 1;
    }

    public static int findSquareSum(int num){
        int sum = 0;
        while(num > 0){
            // num % 10 gives you the right number all the way on the right
            sum = sum + ((num % 10) * (num % 10));
            // by doing this you always remove the right number all the way on the right
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}

package com.JavaAlgos.LeetCode.Top100.Medium;

public class NextPermutation {

    /**
     * So what we know:
     *
     * This is a permutations question - Do back tracking question
     *
     * " lexicographically next greater "
     * "lexicographically" means in terms of the order of their english representation
     *
     *  they are asking for the next greater permutation
     *
     *  And if you can't find that, then you need to sort the list back to sorted ascending order
     *
     *
     *  This is going to use some sort of two pointer technique since they want this done in place
     *
     *
     *  Not sure what's happening here. Still don't get "lexicographically order" for numbers.
     *  Their examples don't seem to make a lot of sense
     *
     *  what does "greater" lexicographically order even mean ?
     *
     *  I guess you should get the letters of the numbers on the fly ??
     *
     *
     *
     *  I guess ignore it the lexi stuff
     *
     *
     *  the default start order is always going to be decreasing
     *  if something is increasing decrease it
     *  if something is decreasing increase it
     *  https://www.youtube.com/watch?v=quAS1iydq7U&ab_channel=BackToBackSWE
     * state space increasing order
     *  you want to get to the point in the input where things are strictly decreasing
     *  then that number will be your start point
     *  then you have to figure out the state space leading up to that number, then swap it with the
     *  next following number from the state space where
     *  then order from lowest to highest everything after the number
     * */
}

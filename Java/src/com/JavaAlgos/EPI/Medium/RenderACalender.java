package com.JavaAlgos.EPI.Medium;

public class RenderACalender {
    /**
     * Kind of a weird question
     * The LC & EPI thing don't match
     * - the LC solution is very different uses a priority queue with a custom compare
     * - the EPI solution just separates and sorts, all the start and end points separately
     *
     *
     * EPI solution is as follows:
     *
     * You take your array of arrays and then make endPoint object with a true or false if they are the start
     * or not
     *
     * Then you take them all and put them in an array, then you call sort with a customer compare
     *
     * And the compare is basically:
     *  if the time values are not the same, then compare
     *
     *  if the time values are the same, then put the one that has a bool of true for start
     *
     * Then loop through the array to of these new ordered values
     *  Count the number of times you see a isStart set to true,
     *  Keep track of the max
     *  If the current value from the loop isStart is false then
     *  reduce the global isStart count by one
     *
     * The reason this works is that, you have all the starts at the beginning, so if a bunch of stuff
     * starts one after the other with no end seen you know that, these X (number of times you counted isStart = true)
     * events are happening concurrently.
     *
     * And every time you see an end, you reduce the count by one, but not set to zero, cause there could be another
     * start after the end and that start could overlap the other starts you have counted.
     *
     * The LC:
     * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510262/Detailed-analysisLet-me-lead-you-to-the-solution-step-by-step
     * **/
}

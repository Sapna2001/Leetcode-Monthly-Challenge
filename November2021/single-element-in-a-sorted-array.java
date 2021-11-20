/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result = result ^ i;
        }
        return result;
    }
}

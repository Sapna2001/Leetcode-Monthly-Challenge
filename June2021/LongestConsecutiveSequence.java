/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3769/
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        int maxLength = 0;
        for(int num : nums) {
            int currentLength = 1;
            int leftElement = num;
            int rightElement = num;
            while(set.contains(leftElement-1)) {
                currentLength++;
                set.remove(leftElement - 1);
                leftElement--;
            }
            while(set.contains(rightElement+1)) {
                currentLength++;
                set.remove(rightElement+1);
                rightElement++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}

/* 
TC: O(n)
SC: O(n)
*/

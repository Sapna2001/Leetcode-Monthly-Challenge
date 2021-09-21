/*
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3982/

TC: O(n)
SC: O(1)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        
        for(int i : nums) {
            if(i == 1) {
                count ++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        
        return max;
    }
}

/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

- 0 <= i < j < nums.length
- |nums[i] - nums[j]| == k

Notice that |val| denotes the absolute value of val.

Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/
*/

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        
        for(int num : nums) {
            int frequency = map.getOrDefault(num, 0) + 1;
            map.put(num, frequency);   
        }
        
        for(int i : map.keySet()) {
            if((k == 0 && map.get(i) > 1) || (k > 0 && map.containsKey(i + k))) {
                result++;
            }
        }
        
        return result;
    }
}

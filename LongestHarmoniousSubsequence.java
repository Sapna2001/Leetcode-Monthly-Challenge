/*

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3628/

Approach -
1. Bitwise Brute force
2. Looping brute force
3. Sorting
4. HashMap
5. HashMap with one loop

Solution Link - https://leetcode.com/problems/longest-harmonious-subsequence/solution/

*/

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.containsKey(i+1))
                res = Math.max(res,map.get(i)+map.get(i+1));
            if(map.containsKey(i-1))
                res = Math.max(res,map.get(i)+map.get(i-1));
        }
        return res;
    }
}
           

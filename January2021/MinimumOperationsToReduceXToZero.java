/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value 
from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3603/
*/

class Solution {
    public int minOperations(int[] nums, int x) {
        int arraySum = 0;
        for(int i : nums)
            arraySum += i;
        int target = arraySum - x;
        if(target==0)
            return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLengthSubArray = 0;
        int prefixSum = 0;
        for(int i = 0 ; i< nums.length ; i++ ) {
            prefixSum += nums[i];
            map.put(prefixSum,i);
            if(map.containsKey(prefixSum - target)) {
                int currentLengthSubArray = i - map.get(prefixSum - target);
                maxLengthSubArray = Math.max(maxLengthSubArray,currentLengthSubArray);
            }
        }
        return (maxLengthSubArray==0) ? -1 :nums.length- maxLengthSubArray;
    }
}

    
        

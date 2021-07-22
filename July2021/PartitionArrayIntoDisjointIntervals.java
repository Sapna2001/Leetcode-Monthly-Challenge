/*
Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3823/
*/

class Solution {
    public int partitionDisjoint(int[] nums) {
        int maxSoFarI = nums[0];
        int maxInLeft = nums[0];
        int partitionIndex = 0;
        
        for(int i = 1 ; i < nums.length ; i++) {
            maxSoFarI = Math.max(maxSoFarI, nums[i]);
            if(nums[i] < maxInLeft) {
                maxInLeft = maxSoFarI;
                partitionIndex = i;
            }
        }
        
        return partitionIndex + 1;
    }
}

/*
TC: O(N)
SC: O(1)
*/

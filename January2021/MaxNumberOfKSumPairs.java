/*

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3608/

*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while(left<right) {
            if(nums[left]+nums[right] == k) {
                count++;
                left++;
                right--;
            } else if(nums[left]+nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}

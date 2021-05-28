/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its 
elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3758/
*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maximumSum = 0, sum = 0, left = 0, right = 0, length = nums.length;
        Set<Integer> unique = new HashSet<>();
        while(right < length) {
            int num = nums[right];
            if(!unique.contains(num)) {
                sum += num;
                unique.add(num);
                maximumSum = Math.max(maximumSum,sum);
                right++;
            } else {
                while(left < right && unique.contains(num)) {
                    int erase = nums[left];
                    unique.remove(erase);
                    sum -= erase;
                    left++;
                }
            }
        }
        return maximumSum;
    }
}


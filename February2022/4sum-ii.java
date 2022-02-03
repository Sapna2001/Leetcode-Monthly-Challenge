/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
- 0 <= i, j, k, l < n
- nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

Link: https://leetcode.com/problems/4sum-ii/
*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int e1 : nums1) {
            for(int e2 : nums2) {
                int sum2Elements = e1 + e2;
                int frequency = map.getOrDefault(sum2Elements, 0) + 1;
                map.put(sum2Elements, frequency);    
            }
        }
        
        int target = 0;
        for(int e3 : nums3) {
            for(int e4 : nums4) {
                int sum2Elements = e3 + e4;
                int frequency = map.getOrDefault(target - sum2Elements, 0);
                count += frequency;
            }
        }
        
        return count;
    }
}

/*
Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

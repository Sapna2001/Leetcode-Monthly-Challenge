/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next 
greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Link: https://leetcode.com/problems/next-greater-element-i/
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums2) {
            while(!stack.isEmpty() && i > stack.peek()) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        
        int[] result = new int[nums1.length];
        
        for(int i = 0 ; i < nums1.length ; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}
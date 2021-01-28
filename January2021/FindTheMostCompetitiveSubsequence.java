/*
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than 
the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3611/

*/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        if(nums.length == k)
            return nums;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            int remaining = n-i-1;
            while(stack.isEmpty() == false && remaining+ stack.size() >=k && stack.peek()>nums[i]) 
                stack.pop();
            stack.push(nums[i]);
        }
        Stack<Integer> reverse = new Stack<>();
        while(!stack.isEmpty()) {
            reverse.push(stack.pop());
        }
        int[] answer = new int[k];
        int i = 0;
        while(!reverse.isEmpty() && i<k) {
            answer[i++] = reverse.peek();
            reverse.pop();
        }
        return answer;
    }
}

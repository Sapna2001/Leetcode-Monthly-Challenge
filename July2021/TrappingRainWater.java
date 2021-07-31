/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3833/

TC: O(n)
SC: O(n)
*/

class Solution {
    public int trap(int[] height) {
        if(height.length <= 1)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int water = 0, i = 0;
        while(i < height.length) {
            if(stack.isEmpty() || height[i] <= height[stack.peek()])
                stack.push(i++);
            else {
                int currentIndex = stack.pop();
                if(!stack.isEmpty()) {
                    int minHeight = Math.min(height[stack.peek()],height[i]);
                    water += (minHeight - height[currentIndex]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }
}

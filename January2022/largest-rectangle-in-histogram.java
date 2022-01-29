/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the 
histogram.

Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
*/

class Solution {
    private int[] nextSmallerRight(int[] heights) {
        int n = heights.length;  
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int[] right = new int[(int)n];
        while(i < n) {
            if(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int index = st.pop();
                right[index] = i;
            } else {
                st.push(i);
                i++;
            }
        }
        
        while(!st.isEmpty()) {
            int index = st.pop();
            right[index] = n;
        } 
        
        return right;
    }
    
    private int[] nextSmallerLeft(int[] heights) {
        int n = heights.length;  
        Stack<Integer> st = new Stack<Integer>();
        int i = n - 1;
        int[] left = new int[(int)n];
        while(i >= 0) {
            if(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int index = st.pop();
                left[index] = i;
            } else {
                st.push(i);
                i--;
            }
        }
        
        while(!st.isEmpty()) {
            int index = st.pop();
            left[index] = -1;
        }     
        
        return left;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int right[] = nextSmallerRight(heights);
        int left[] = nextSmallerLeft(heights);
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++) {
            int length = right[i] - left[i] - 1;
            int area = length * heights[i];
            max = Math.max(max, area);
        }
        
        return max;
    }
}

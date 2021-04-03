/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Link : https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3695/
*/

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                max = Math.max(max,i-stack.peek());
            }
        }
        return max;
    }
}

/*
TC : O(n)
SC : O(N)
*/

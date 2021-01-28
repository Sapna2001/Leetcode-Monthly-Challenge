/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3610/

*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.add(c);
            else if (stack.size()>0 &&
                     ((c == ')' && stack.peek() == '(') ||
                     (c == '}' && stack.peek() == '{') ||
                     (c == ']' && stack.peek() == '[')))
                stack.pop();
            else
                return false;
        }
        
        return stack.size() == 0;
    }
}

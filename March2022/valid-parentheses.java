/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Link: https://leetcode.com/problems/valid-parentheses/
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

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

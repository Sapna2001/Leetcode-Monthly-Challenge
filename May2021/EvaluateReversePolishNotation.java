/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3755/
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        
        for(String element : tokens) {
            if(isOperator(element)) {
                int element2 = Integer.parseInt(stack.pop());
                int element1 = Integer.parseInt(stack.pop());
                int ans = 0;
                
                if(element.equals("*"))
                    ans = element1 * element2;
                else if(element.equals("/"))
                    ans = element1 / element2;
                else if(element.equals("+"))
                    ans = element1 + element2;
                else if(element.equals("-"))
                    ans = element1 - element2;
                
                stack.push(Integer.toString(ans));
            } else 
                stack.push(element);
        }
        return Integer.parseInt(stack.peek());
    }
    
    private boolean isOperator(String element) {
        if(element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-"))
            return true;
        return false;
    }
}

// TC : O(n)

/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Link: https://leetcode.com/problems/basic-calculator-ii/
*/

class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        } 
        
        int length = s.length(), currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for(int i = 0 ; i < length ; i++) {
            char currentCharacter = s.charAt(i);
            if(Character.isDigit(currentCharacter)) {
                currentNumber = (currentNumber * 10) + (currentCharacter - '0');    
            }
            if(!(Character.isDigit(currentCharacter)) && !(Character.isWhitespace(currentCharacter)) || (i == length - 1)) {
                if((operation == '+') || (operation == '-')) {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if(operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if(operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentCharacter;
                currentNumber = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
*/

class Solution {
    public int calculate(String s) {
        int sign = 1, ans = 0, currentNo = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(Character.isDigit(s.charAt(i))) {
                currentNo = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    currentNo = currentNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                currentNo = currentNo * sign;
                ans += currentNo;
                currentNo = 0;
            } else if(s.charAt(i) == '+') {
                sign = 1;
            } else if(s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int previousSign = stack.pop();
                ans *= previousSign;
                int previousAns = stack.pop();
                ans += previousAns;
            }
        }
        return ans;
    }
}

/*
TC: O(n)
SC: O(1)
*/

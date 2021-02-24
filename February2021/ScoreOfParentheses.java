/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/
*/
class Solution {
    public int scoreOfParentheses(String S) {
        int ans = 0 , bal = 0;
        for(int i = 0 ; i < S.length() ; i++) {
            if(S.charAt(i)=='(')
                bal++;
            else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }
        return ans;
    }
}

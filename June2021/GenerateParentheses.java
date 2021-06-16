/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3781/
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backTrack(list, new StringBuilder(), 0, 0,n);
        return list;
    }
    
    private void backTrack(List<String> list,StringBuilder str, int open, int closed, int n) {
        if(closed > open)
            return;
        
        if(closed == open && str.length() == n*2) {
            list.add(str.toString());
            return;
        }
        
        if(open < n) {
            str.append("(");
            backTrack(list, str, open + 1, closed, n);
            str.deleteCharAt(str.length() - 1);
        }
        
        if(closed < open) {
            str.append(")"); 
            backTrack(list, str, open, closed + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

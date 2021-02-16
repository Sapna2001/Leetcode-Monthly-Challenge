/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3642/
*/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> answer = new ArrayList<>();
        if(S.length() == 0)
            return answer;
        helper(S.toCharArray(), answer, 0);
        return answer;
    }
    public void helper(char[] str, List<String> answer, int index) {
        if(str.length == index) {
            answer.add(new String(str));
            return;
        }
        if(Character.isDigit(str[index])) {
            helper(str, answer, index+1);
            return;
        } else {
            str[index] = Character.toLowerCase(str[index]);
            helper(str, answer, index+1);
            str[index] = Character.toUpperCase(str[index]);
            helper(str, answer, index+1);
        }
            
    }
}

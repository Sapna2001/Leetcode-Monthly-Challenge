/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3701/
*/

class Solution {
    String[] combinations = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty())
            return ans;
        
        dfs(0,new StringBuilder(),digits,ans);
        return ans;
    }
    
    void dfs(int index, StringBuilder current, String digits,List<String> ans) {
        if(index == digits.length()) {
            ans.add(current.toString());
            return;
         }
        char currentCharacter = digits.charAt(index);
        for(char c:combinations[currentCharacter-'0'].toCharArray())
        {
            current.append(c);
            dfs(index+1,current,digits,ans);
            current.deleteCharAt(current.length()-1);
        }
    }
}

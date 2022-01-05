/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Link: https://leetcode.com/problems/palindrome-partitioning/
*/

class Solution {
    private boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }
    
    private void helper(List<List<String>> result, List<String> currentList,String s) {
        if(s.length() == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }  
        
        for(int i = 0 ; i < s.length() ; i++) {
            String firstPart = s.substring(0, i+1);
            if(isPalindrome(firstPart)) {
                currentList.add(firstPart);
                String secondPart = s.substring(i+1, s.length());
                helper(result, currentList, secondPart);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length() == 0 || s == null) {
            return result;
        }
        
        helper(result, new ArrayList<>(), s);
        return result;
    }
}

/*
Time Complexity : O(N . 2^N)
Space Complexity: O(N)
*/


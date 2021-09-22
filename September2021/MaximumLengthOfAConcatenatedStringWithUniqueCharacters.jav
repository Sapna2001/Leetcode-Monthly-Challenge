/*
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3984/
*/

class Solution {
    private boolean uniqueCharString(String str) {
        if(str.length() > 26)
            return false;
        
        char[] frequencyArray = new char[26];
        char[] chArray = str.toCharArray();
        
        for(char ch : chArray) {
            frequencyArray[ch - 'a']++;
            if(frequencyArray[ch - 'a'] > 1)
                return false;
        }
        
        return true;    
    }
    
    public int maxLength(List<String> arr) {
        List<String> resultList = new ArrayList<>();
        int count = 0;
        
        resultList.add("");
        for(String str : arr) {
            if(!uniqueCharString(str))
                continue;
            
            List<String> newListWithCurrStr = new ArrayList<>();
            
            for(String possibleStr : resultList) {
                String temp = possibleStr + str;
                if(uniqueCharString(temp)) {
                    newListWithCurrStr.add(temp);
                    count = Math.max(count, temp.length());
                }
            }
            
            resultList.addAll(newListWithCurrStr);
        }
        return count;
    }
}

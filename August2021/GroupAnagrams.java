/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/

TC: O(n*len(eachString)
SC: O(n)
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = buildKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
         return new ArrayList<>(map.values());
    }  
    
    String buildKey(String str) {
        char[] keyChar = new char[26];
        for(char ch : str.toCharArray()) {
            keyChar[ch - 'a']++;
        }
        return new String(keyChar);
    }
}


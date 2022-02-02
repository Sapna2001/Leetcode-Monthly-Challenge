/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

class Solution {
    private boolean isAnagram(String s, String p) {
        int charArray[] = new int[26];
        int l = s.length();
        
        for(int i = 0 ; i < l ; i++) {
            int sLetter = s.charAt(i) - 'a', pLetter = p.charAt(i) - 'a';
            charArray[sLetter]++;
            charArray[pLetter]--;
        }
        
        for(int i = 0 ; i < 26 ; i++) {
            if(charArray[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int l1 = s.length(), l2 = p.length();
        
        for(int i = 0 ; i < l1 - l2 + 1 ; i++) {
            String subStr = s.substring(i, i + l2);
            if(isAnagram(subStr,p)) {
                result.add(i);
            }
        }
        
        return result;
    }
}

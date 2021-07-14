/*
order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, 
if x occurs before y in order, then x should occur before y in the returned string.

Return any permutation of str (as a string) that satisfies this property.

Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3813/
*/

class Solution {
    public String customSortString(String order, String str) {
        int[] frequency = new int[26];
        
        // O(len str)
        for(char c : str.toCharArray())
            frequency[c-'a']++;
        
        StringBuilder res = new StringBuilder();
        
        // O(len str + len order)
        for(char c : order.toCharArray()) {
            while(frequency[c-'a']> 0) {
                res.append(c);
                frequency[c-'a']--;
            }
        }
        
        // O(len str)
        for(int i = 0 ; i < 26; i++) {
            int frequencyChar = frequency[i];
            while(frequencyChar > 0) {
                res.append((char)(i+'a'));
                frequencyChar--;
            }
        }
        return res.toString();
    }
}

// TC: O(len str + len order)

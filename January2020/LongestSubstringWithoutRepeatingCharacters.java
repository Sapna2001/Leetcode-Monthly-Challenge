/*
Given a string s, find the length of the longest substring without repeating characters.
Link - https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,max=0;
        HashSet<Character> hashSet = new HashSet();
        while(j<s.length()) {
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                j++;
                max = Math.max(max,hashSet.size());
            } else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}

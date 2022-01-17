/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Link: https://leetcode.com/problems/word-pattern/
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(str.length != pattern.length()) {
            return false;
        } 
        
        HashMap<Character,String> hashMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
            hashMap.putIfAbsent(pattern.charAt(i), str[i]);
            set.add(str[i]);
            
            if(!hashMap.get(pattern.charAt(i)).equals(str[i])) {
                return false;
            }
        }
        
        return set.size() == hashMap.size();
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

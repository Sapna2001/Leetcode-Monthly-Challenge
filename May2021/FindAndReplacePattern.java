/*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3750/
*/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String normalizedPattern = normalize(pattern);
        List<String> ans = new ArrayList<String>();
        for(String word : words)
            if(normalizedPattern.equals(normalize(word)))
                ans.add(word);
        return ans;
    }
    public String normalize(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        String ans = "";
        
        for(int i = 0 ; i < str.length() ; i++) {
            map.putIfAbsent(str.charAt(i),map.size());
            ans += map.get(str.charAt(i));
        }
        return ans;
    }
}

/*
TC: O(n*l)
SC: O(n*l)
*/

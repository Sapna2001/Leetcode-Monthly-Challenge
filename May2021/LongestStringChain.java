/*
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2. For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

Link: https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3746/
*/

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length() - b.length()); 
        Map<String, Integer> dp = new HashMap<>();
        int ans = 0;
        for (String word : words) { 
            int longestChainWithCurrentWord = 0;
            for (int i = 0; i < word.length(); i++) { 
                String predecessor = word.substring(0, i) + word.substring(i + 1, word.length());
                longestChainWithCurrentWord = Math.max(longestChainWithCurrentWord, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, longestChainWithCurrentWord);
            ans = Math.max(ans, longestChainWithCurrentWord);
    }
        return ans;
    }
}

/* 
TC : O(n * l*l) 
SC : O(n)
*/

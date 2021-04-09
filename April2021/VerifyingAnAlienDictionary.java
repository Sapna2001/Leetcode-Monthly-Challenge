/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien 
language.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3702/
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i = 0 ; i < order.length() ; i++) 
            index[order.charAt(i) - 'a'] = i;
        for(int i = 0 ; i < words.length - 1; i++) {
            for(int j = 0 ; j < words[i].length() ; j++) {    
                if(j >= words[i + 1].length()) 
                    return false;
                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    int current = words[i].charAt(j) - 'a';
                    int next = words[i+1].charAt(j) - 'a';
                    if(index[current] > index[next])
                        return false;
                    else
                        break;
                }
            }
        }
        return true;
    }
}

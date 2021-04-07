/*
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3699/
*/

class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        return vowelCount(s,vowelSet,0,s.length()/2) == vowelCount(s,vowelSet,s.length()/2,s.length());
    }
    
    public int vowelCount(String s, Set<Character> vowelSet, int start, int end) {
        int count = 0;
        for(int i = start ; i < end ; i++)
            if(vowelSet.contains(s.charAt(i)))
                count++;
        return count;
    }
}

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra 
spaces.

Link: https://leetcode.com/problems/reverse-words-in-a-string/
*/

class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        Stack<String> stack = new Stack<>();
        String word = "";
        
        for(int i = 0; i < s.length(); i++){
            while(i < s.length() && charArray[i] == ' '){
                i++;
            }

            while(i < s.length() && charArray[i] != ' '){
                word += charArray[i];
                i++;
            }
            
            stack.push(word);
            word = "";
        }

        String result = "";
        while(!stack.empty()){
            String top = stack.pop();
            result = result + " " + top;
        }

        return result.trim();   
    }
}

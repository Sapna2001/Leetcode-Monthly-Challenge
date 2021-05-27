/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3757/
*/

class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] state = new int[length];   
        
        for(int i = 0 ; i < length ; i++)
            state[i] = getState(words[i]);
        
        int maxProduct = 0;
        for(int i = 0 ; i < length ; i++) {
            for(int j = i + 1 ; j < length ; j++) {
                if((state[i] & state[j]) == 0) 
                    maxProduct = Math.max(maxProduct,words[i].length() * words[j].length());
            }
        }
        return maxProduct;
    }
    
    private int getState(String str) {
        int state = 0;
        for(char c: str.toCharArray()){
            int index = c - 'a';
            state |= 1 << (index);
        }
        return state;
    }
}

/*
TC : O(n^2)
SC: O(n)
*/

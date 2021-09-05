/*
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3964/
*/

class Solution {
    public String orderlyQueue(String str, int k) {
        if(k == 0)
            return str;
        else if(k > 1) {
            char[] chStr = str.toCharArray();
            Arrays.sort(chStr);
            return new String(chStr);
        } else if(k==1) {
            String result = str;
            for(int i = 1; i < str.length() ; i++) {
                String reorderedStr = str.substring(i) + str.substring(0,i);
                if(result.compareTo(reorderedStr) > 0)
                    result = reorderedStr;
            }
            return result;
        }
        return str;
    }
}

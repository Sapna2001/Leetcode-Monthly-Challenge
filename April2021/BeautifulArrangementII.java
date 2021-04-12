/*
Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3705/
*/

class Solution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int left = 1, right = n, index = 0;
        while(left<=right) {
            if(k>1)
                answer[index++] = k-- % 2 != 0 ? left++ : right--;
            else
                answer[index++] = left++;
        }   
        return answer;
    }
}

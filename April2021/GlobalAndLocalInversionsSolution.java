/*
We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

Return true if and only if the number of global inversions is equal to the number of local inversions.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3697/
*/

class Solution {
    public boolean isIdealPermutation(int[] A) {
        int max = 0;
        for(int i = 0 ; i < A.length - 2 ; i++) {
            max = Math.max(max,A[i]);
            if(max>A[i+2])
                return false;
        }
        return true;
    }
}

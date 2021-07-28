/*
For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:

For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].

Given n, return any beautiful array nums.  (It is guaranteed that one exists.)

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3829/
*/

class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();  
            // odd arrayt
            for(int element : ans) {
                if(2 * element - 1 <= n) 
                    temp.add(2 * element - 1);
            }
            // even array
            for(int element : ans) {
                if(2 * element <= n) 
                    temp.add(2 * element);
            }
            ans = temp;
        }
        int[] resultArray = new int[n];
        for(int i = 0 ; i < n ; i++) {
            resultArray[i] = ans.get(i);
        }
        return resultArray;
    }
}

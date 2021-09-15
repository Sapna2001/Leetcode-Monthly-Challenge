/*
Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3976/
*/

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length < 2)
            return arr.length;
        
        int max = 1, start = 0, end = 0, length = arr.length;
        
        while(start + 1 < length) {
            if(arr[start] == arr[start+1]) {
                start++;
                continue;
            }
            
            end = start + 1;
            while(end + 1 < length && isTurbluent(arr, end))
                end++;
            
            max = Math.max(max, end - start + 1);
            start = end;
        }
        return max;
    }
    
    private boolean isTurbluent(int[] arr, int k) {
        return (((arr[k] > arr[k-1]) && (arr[k] > arr[k+1]))  || ((arr[k] < arr[k-1])  && (arr[k] < arr[k+1])));
    }
}

/*
TC: O(1)
SC: O(1)
*/

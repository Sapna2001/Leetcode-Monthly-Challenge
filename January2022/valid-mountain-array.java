/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:
- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
  - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
  - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Link: https://leetcode.com/problems/valid-mountain-array/
*/

class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0, n = arr.length;
        
        if(n < 3) {
            return false;
        }
        
        while(i+1 < n && arr[i] < arr[i+1]) {
            i++;
        }
        
        if(i == 0 || i == n - 1) {
            return false;
        }
        
        while(i+1 < n && arr[i] > arr[i+1]) {
            i++;
        }
        
        boolean result = (i == n - 1);
        return result;
    }
}

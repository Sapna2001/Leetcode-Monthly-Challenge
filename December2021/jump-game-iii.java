/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or 
i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Link: https://leetcode.com/problems/jump-game-iii/
*/

class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }    
        
        if(arr[start] == 0) {
            return true;
        }
        
        arr[start] = -arr[start];
        
        return  canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}

/*
T.C : O(n)
S.C : O(n) 
*/

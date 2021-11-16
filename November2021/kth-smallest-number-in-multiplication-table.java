/*
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

Link: https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
*/

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int capacity = count(mid, m , n);
            
            if(capacity >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private int count(int mid, int m, int n) {
        int count = 0;
        for(int i = 1 ; i <= m ; i++) {
            int temp = Math.min(mid / i, n);
            count += temp;
        }
        return count;
    }
}

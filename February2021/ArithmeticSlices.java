/*
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

Link - 
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3644/
*/

// approach 1
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for(int i = 0 ; i < A.length - 2 ; i++) {
            int d = A[i+1] - A[i];
            for(int j = i + 2 ; j < A.length ; j++) {
               int k = 0;
               for(k = i + 1 ; k <= j ; k++) {
                   if(A[k]-A[k-1]!=d)
                       break;   
               }
               if(k>j)
                   count++;
        }
    }
        return count;
    }
}
// TC : O(n^3)
// SC : O(1)

// approach 2
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for(int i = 0 ; i < A.length - 2 ; i++) {
            int d = A[i+1] - A[i];
            for(int j = i + 2 ; j < A.length ; j++) {
                if((A[j] - A[j-1]) == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
// TC : O(n^2)
// SC : O(1)

// approach 3
class Solution {
    int count = 0;
    public int numberOfArithmeticSlices(int[] A) {
        slices(A,A.length-1);
        return count;
    }
    public int slices(int[] A, int index) {
        if(index<2)
            return 0;
        int sum = 0;
        if(A[index]-A[index-1]==A[index-1]-A[index-2]) {
            sum = 1 + slices(A,index-1);
            count+=sum;
        } else
            slices(A,index-1);
        return sum;
    }
}
// TC : O(n)
// SC : O(1)


/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
       int num = 1, i = 0;
        while(k!=0) {
            if(i<arr.length && arr[i]==num)
                i++;
            else 
                k--;
            if(k==0)
                return num;
            num++;
        }
        return 0;
    }
}

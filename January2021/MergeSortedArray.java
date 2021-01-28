/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough space (size that is equal to m + n) to hold additional 
elements from nums2.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3600/

*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int array1Pointer = m - 1;
        int array2Pointer = n - 1;
        int pointer = nums1.length - 1;
        while(pointer>=0) {
            int firstElement = array1Pointer>=0 ? nums1[array1Pointer] : Integer.MIN_VALUE;
            int secondElement = array2Pointer>=0 ? nums2[array2Pointer] : Integer.MIN_VALUE;
            if(firstElement>secondElement) {
                nums1[pointer--] = firstElement;
                array1Pointer --;
            } else {
                nums1[pointer--] = secondElement;
                array2Pointer --;
            }
        }
    }
}

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may 
return the result in any order.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3978/
TC: O(nlogn+mlogm)
SC: O(min(n,m))
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        int start1 = 0, start2 = 0, count = 0;
        
        while(start1 < nums1.length && start2 < nums2.length) {
            if(nums1[start1] > nums2[start2]) {
                start2++;
            } else if(nums2[start2] > nums1[start1]) {
                start1++;
            } else {
                list.add(nums1[start1]);
                count++;
                start1++;
                start2++;
            }
        }
        
        int[] result = new int[count];
        
        for(int i = 0 ; i < count ; i++) {
           result[i] = list.get(i);   
        }
        
        return result;
    }
}

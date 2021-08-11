/*
Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 
0 <= i < len(arr) / 2. 

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/

TC: O(nlogn)
SC: O(n)
*/

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        // map with frequency
        // tree map to have it sorted
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : arr) 
            map.put(i, map.getOrDefault(i,0) + 1);
        
        for(int i : map.keySet()) {
            if(map.getOrDefault(i,0) > 0) {
                // odd
                if(i % 2 != 0 && i < 0)
                    return false;
            
                int target = i < 0 ? (i/2) : (i*2);
            
                if(map.get(i) > map.getOrDefault(target,0))
                    return false;
            
                map.put(target, map.get(target) - map.get(i));   
            }
        }
        return true;
    }
}

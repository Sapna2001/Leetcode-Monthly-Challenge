/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

- a, b are from arr
- a < b
- b - a equals to the minimum absolute difference of any two elements in arr

Link: https://leetcode.com/problems/minimum-absolute-difference/
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array
        Arrays.sort(arr);
        
        // Find the minimum difference between the adjacent elements
        for(int i = 0 ; i < arr.length - 1 ; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        
        // Add the pair with the minimum difference
        for(int i = 0 ; i < arr.length - 1 ; i++) {
            if(arr[i] + min == arr[i + 1]) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        
        return result;
    }
}

/*
Time Complexity: O(nlogn)
Space Complexity: O(1)
*/

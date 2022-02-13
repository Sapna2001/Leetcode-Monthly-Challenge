/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Link: https://leetcode.com/problems/subsets/
*/

class Solution {
    private static void solve(int len, int index, int []nums, List<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == len) {
           result.add(new ArrayList<>(temp));
           return;    
        }   
        
        for(int i = index; i < nums.length; i++) {
          temp.add(nums[i]);
          solve(len, i + 1,nums,temp,result);
          temp.remove(temp.size() - 1); 
       }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(); 
        for(int len = 0 ; len <= nums.length ; len++) {
            solve(len, 0, nums, temp, result);    
        }
        
        return result;
    }
}

/*
Time complexity: O(N * (2^N))
Space Complexity: O(N);
*/

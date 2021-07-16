/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3816/ 
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
    for (int i = 0; i < nums.length - 3; i++) {
      // dupilicates
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < nums.length - 2; j++) {
        // dupilicates
        if (j != i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }

        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];

          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            List<Integer> combination = new ArrayList<>();
            combination.add(nums[i]);
            combination.add(nums[j]);
            combination.add(nums[left]);
            combination.add(nums[right]);

            result.add(combination);
            left++;
            right--;

             // dupilicates
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }

            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }
          }
        }
      }
    }
        return result;
    }
}

/*
TC: O(n^3)
SC: O(1)
*/

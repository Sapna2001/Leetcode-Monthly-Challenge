/*
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3990/
*/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int oddNoAtEvenIndex= 0, evenNoAtOddIndex = 1, n = nums.length;    
        
        while(oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {
            while (oddNoAtEvenIndex < n && nums[oddNoAtEvenIndex] % 2 == 0) {
                oddNoAtEvenIndex += 2;
            }
            
            while (evenNoAtOddIndex < n && nums[evenNoAtOddIndex] % 2 == 1) {
                evenNoAtOddIndex += 2;
            }
            
            if (evenNoAtOddIndex < n && oddNoAtEvenIndex < n) {
                swap(nums, oddNoAtEvenIndex, evenNoAtOddIndex);
            }  
        }

        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

/*
TC : O(n)
SC : O(1)
*/

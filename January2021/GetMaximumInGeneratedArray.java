/*
You are given an integer n. An array nums of length n + 1 is generated in the following way:

nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums.

Link :- https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3605/
*/

class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        int[] generatedArray = new int[n+1];
        generatedArray[0] = 0;
        generatedArray[1] = 1;
        int max = 1;
        for(int i = 2; i<=n;i++) {
            if(i%2==0)
                generatedArray[i] = generatedArray[i/2];
            else 
                generatedArray[i] = generatedArray[i/2] + generatedArray[i/2+1];
            max = Math.max(max,generatedArray[i]);
        }
        return max;
    }
}

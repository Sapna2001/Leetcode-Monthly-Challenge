/*
Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of 
the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the 
score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3775/
*/

class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        int[][] dp = new int[n][n];
        
        for(int[] dpRow : dp)
            Arrays.fill(dpRow,-1);
        
        for(int stone : stones)
            sum += stone;
        
        return solve(0, n - 1, stones, sum, dp);
    }
    
    private int solve(int left, int right, int[] stones, int sum, int[][] dp) {
        if(left == right)
            return 0;
        
        if(right - left == 1)
            return Math.max(stones[left],stones[right]);
        
        if(dp[left][right] != -1)
            return dp[left][right];
        
        int maxDifference = Math.max(sum - stones[left] - solve(left + 1,right, stones, sum - stones[left], dp),
                                     sum - stones[right] - solve(left, right - 1, stones, sum - stones[right], dp));
        
        dp[left][right] = maxDifference;
        return maxDifference;
    }
}

/*
TC : O(n^2)
SC : O(n^2)
*/

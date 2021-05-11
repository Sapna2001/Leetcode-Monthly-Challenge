/*
There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // minimum subarry to get max sum
        int minSubarrayLength = cardPoints.length - k, minSum = Integer.MAX_VALUE;        
        int left = 0, currentSum = 0, total = 0;   
        for (int i = 0 ; i < cardPoints.length ; i++) {
            total += cardPoints[i];
            currentSum += cardPoints[i];
            if(i - left + 1 == minSubarrayLength) {
                minSum = Math.min(minSum, currentSum);
                currentSum -= cardPoints[left];
                left++;
            }
        }
        return total - (minSum == Integer.MAX_VALUE ? 0 : minSum);  
    }
}

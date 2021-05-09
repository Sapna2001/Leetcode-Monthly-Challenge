/*
Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :

- let x be the sum of all elements currently in your array.
- choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
- You may repeat this procedure as many times as needed.
- Return True if it is possible to construct the target array from A otherwise return False.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3737/
*/

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        long totalSum = 0;
        
        for(int no : target) {
            priorityQueue.add(no);
            totalSum += no;
        }
        
        while(!priorityQueue.isEmpty()) {
            int maxElement = priorityQueue.remove();
            long sumOfRemainingElements = totalSum - maxElement;
            if(maxElement == 1 || sumOfRemainingElements == 1)
                return true;
            if(sumOfRemainingElements == 0 || maxElement < sumOfRemainingElements) 
                return false;
            int updatedMax = (int)(maxElement % sumOfRemainingElements);
            if(updatedMax == 0)
                return false;
            maxElement = updatedMax;
            priorityQueue.offer(maxElement);
            totalSum = updatedMax + sumOfRemainingElements;
        }
        return true;
    }
}

// TC : O(nlogn)
// SC : O(n)

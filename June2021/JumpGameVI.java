/*
You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i
to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.
*/

class Solution {
    public int maxResult(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        
        Queue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        
        priorityQueue.offer(new int[]{nums[0], 0});
        
        int max = nums[0];
        
        for(int i = 1; i < nums.length ; i++) {
            while(i - priorityQueue.peek()[1] > k) {
                priorityQueue.poll();
            }
            
            int[] current = priorityQueue.peek();
            max = current[0] + nums[i];
            priorityQueue.offer(new int[]{max, i});
        }
        return max;
    }
}

/* 
TC: O(nlogk)
SC: O(k)
*/

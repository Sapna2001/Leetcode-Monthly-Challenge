/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Link: https://leetcode.com/problems/k-closest-points-to-origin/
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])));
        
        for(int[] point : points) {
            priorityQueue.offer(point);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        
        int[][] result = new int[priorityQueue.size()][2];
        int count = 0;
        while(!priorityQueue.isEmpty()) {
            result[count] = priorityQueue.poll();
            count++;
        }
        
        return result;
    }
}

/*
Time Complexity: O(nlogk)
Space Complexity: O(k)
*/

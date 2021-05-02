/*
There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3729/
*/

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> (a[1] - b[1]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer> ((a,b) -> (b - a));
        int timelapsed = 0;
        for(int[] course : courses) {
            if(timelapsed + course[0] <= course[1]) {
                priorityQueue.offer(course[0]);
                timelapsed +=course[0];
            } else if(!priorityQueue.isEmpty() && priorityQueue.peek() >= course[0]) {
                timelapsed = timelapsed - priorityQueue.poll();
                priorityQueue.offer(course[0]);
                timelapsed = timelapsed + course[0];
            } else {
                // priorityQueue.peek() < course[0] 
                // reject the current course
            }
        }
        return priorityQueue.size();
    }
}

// TC : O(nlogn)
// SC : O(n)

/*
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is 
empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

Link: https://leetcode.com/problems/maximize-distance-to-closest-person/
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        
        int[] left = new int[n];
        Arrays.fill(left, -1);
        
        int[] right = new int[n];
        Arrays.fill(right, -1);
        
        int index = 0;
        
        int lastFilled = -1, maxDistance = -1;
        
        while(index < n) {
            if(seats[index] == 1) {
                lastFilled = index;
            } else {
                left[index] = lastFilled;
            }
            index++;
        }
        
        index = n-1;
        lastFilled = -1;
        
        while(index >= 0) {
            if(seats[index] == 1) {
                lastFilled = index;
            } else {
                right[index] = lastFilled;
            }
            index--;    
        }
        
        for(int i = 0 ; i < n ; i++) {
            if(seats[i] == 0) {
                int leftDistance = (left[i] != -1) ? i - left[i] : Integer.MAX_VALUE;
                int rightDistance = (right[i] != -1) ? right[i] - i: Integer.MAX_VALUE;
                int currentDistance = Math.min(leftDistance, rightDistance);
                maxDistance = Math.max(maxDistance, currentDistance);
            }
        }
        
        return maxDistance;
    }
}

/*
Time complexity: O(n)
Space complexity: O(n)
*/

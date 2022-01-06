/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and 
the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial 
location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Link: https://leetcode.com/problems/car-pooling/
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] occupancy = new int[1001];
        for(int i = 0 ; i < trips.length ; i++) {
            occupancy[trips[i][1]] += trips[i][0];   
            occupancy[trips[i][2]] -= trips[i][0];
        }
        
        int currentCapacity = 0;
        for(int currentOccupancy : occupancy) {
            currentCapacity += currentOccupancy;
            if(currentCapacity > capacity) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(1)
*/

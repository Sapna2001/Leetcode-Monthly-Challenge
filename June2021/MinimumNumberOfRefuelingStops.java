/*
A car travels from a starting position to a destination which is target miles east of the starting position.

Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters 
of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to 
have arrived.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3776/
*/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int xCurrent = startFuel;
        int minStops = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> (b - a));
        
        for(int[] station : stations) {
            int nextStation = station[0];
            int nextFuel = station[1];
            while(xCurrent < nextStation) {
                if(priorityQueue.isEmpty())
                    return -1;
                int maxFuel = priorityQueue.poll();
                xCurrent += maxFuel; 
                minStops++;
            }
            priorityQueue.offer(nextFuel);
        }
        while(xCurrent < target) {
            if(priorityQueue.isEmpty())
                    return -1;
             int maxFuel = priorityQueue.poll();
             xCurrent += maxFuel;
             minStops++;    
        }
        return minStops;
    }
}

/*
TC: O(nlogn)
SC: O(n)
*/

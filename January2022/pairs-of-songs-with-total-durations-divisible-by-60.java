/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j 
with (time[i] + time[j]) % 60 == 0.

Link: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int currentDuration : time) {
            if((currentDuration % 60) == 0) {
                count += map.getOrDefault(0, 0);
            }  else {
                count += map.getOrDefault(60 - (currentDuration % 60), 0);    
            }  
            map.put((currentDuration % 60), map.getOrDefault(currentDuration % 60, 0) + 1);
        }
        
        return count;
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

/*
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. 
You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/
*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4)
            return false;
        
        int perimeter = 0;
        
        for(int i : matchsticks)
            perimeter += i;
        
        if((perimeter % 4) != 0)
            return false;
       
        Arrays.sort(matchsticks);
        int side = perimeter / 4;
        
        int[] sides = new int[] {side, side, side, side};
        
        return isPossible(matchsticks, 0, sides);
    }
    
    private boolean isPossible(int[] matchsticks, int usedSticks, int[] sides) {
        if(usedSticks == matchsticks.length)
            return ((sides[0] == 0) && (sides[1] == 0) && (sides[2] == 0) && (sides[3] == 0));
        
        for(int i = 0 ; i < 4 ; i++) {
            if(matchsticks[usedSticks] > sides[i])
                continue;
            sides[i] -= matchsticks[usedSticks];
            if(isPossible(matchsticks, usedSticks + 1, sides))          
                return true;
            sides[i] += matchsticks[usedSticks];
        }
        return false;
    }
}

// TC : O(4^N)

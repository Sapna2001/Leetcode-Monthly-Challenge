/*
Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.

An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3726/
*/

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        
        for(int powerX = 1; powerX < bound; powerX  = powerX  * x) { 
            for(int powerY = 1; powerY  < bound; powerY = powerY * y) {  
                int generatedNo = powerX  + powerY;
                if(generatedNo<=bound)
                    set.add(generatedNo);
                if(y == 1)
                    break;
            }
            if(x == 1)
               break;
        }   
        
        return new ArrayList<>(set);
    }
}

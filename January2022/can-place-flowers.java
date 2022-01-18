/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the 
flowerbed without violating the no-adjacent-flowers rule.

Link: https://leetcode.com/problems/can-place-flowers/
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, index = 0;
        while(index < flowerbed.length) {
            if(flowerbed[index] == 0 && (index == 0 || flowerbed[index - 1] == 0) && (index == flowerbed.length - 1 || flowerbed[index + 1] == 0)) {
                flowerbed[index] = 1;
                count++;
            }
            index++;
        }
        
        boolean result = count >= n ? true : false;
        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

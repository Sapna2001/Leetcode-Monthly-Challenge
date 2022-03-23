/*
There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
- multiply the number on display by 2, or
- subtract 1 from the number on display.

Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

Link: https://leetcode.com/problems/broken-calculator/
*/

class Solution {
    public int brokenCalc(int start, int target) {
        int result = 0;
        while(target > start) {
            if(target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
            
            result++;
        }
        result += (start - target);
        return result;
    }
}

/*
Time Complexity: O(log(target))
Space Complexity: O(1)
*/

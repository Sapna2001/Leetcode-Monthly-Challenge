/*
On a broken calculator that has a number showing on its display, we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3647/
*/

class Solution {
    public int brokenCalc(int X, int Y) {
        if(X>=Y)
            return X-Y;
        if(Y%2==0)
            return brokenCalc(X,Y/2) + 1;
        return brokenCalc(X,Y+1)+1;
    }
}

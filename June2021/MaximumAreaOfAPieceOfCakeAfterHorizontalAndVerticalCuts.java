/*
Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the 
rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can 
be a huge number, return this modulo 10^9 + 7.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3766/
*/

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxHeight = Math.max(horizontalCuts[0]-0, h - horizontalCuts[horizontalCuts.length - 1]);
        for(int i = 1 ; i < horizontalCuts.length ; i++) {
            int horizontalWidth = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight, horizontalWidth);
        }
        
        
        int maxWidth = Math.max(verticalCuts[0]-0, w - verticalCuts[verticalCuts.length - 1]);
        for(int i = 1 ; i < verticalCuts.length ; i++) {
            int verticalWidth = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth, verticalWidth);
        }
        
        long ans = 1L * maxHeight * maxWidth;
        int result = (int)(ans % 1000000007);
        return result;
    }
}

/*
TC: O(vlogv + hlogh)
*/

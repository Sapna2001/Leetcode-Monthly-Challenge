/*
Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3917/

Time complexity : O(1)
Space complexity : O(1)
*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String x[] = num1.split("\\+|i");
        String y[] = num2.split("\\+|i");
        
        int num1Real = Integer.parseInt(x[0]), num1Img = Integer.parseInt(x[1]), 
            num2Real = Integer.parseInt(y[0]), num2Img = Integer.parseInt(y[1]);
        
        String result = (num1Real * num2Real - num1Img * num2Img) + "+" + (num1Real * num2Img + num1Img * num2Real) + "i";
        
        return result;
    }
}

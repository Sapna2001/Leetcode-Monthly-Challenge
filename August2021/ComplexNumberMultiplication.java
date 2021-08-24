/*
A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

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

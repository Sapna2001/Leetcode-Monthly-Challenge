/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Link: https://leetcode.com/problems/multiply-strings/
*/

class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length(); 
        
        if(l1 == 0 || l2 == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        
        if ("1".equals(num1)) {
            return num2;
        }
        
        if ("1".equals(num2)) {
            return num1;
        }
        
        int[] result = new int[l1 + l2];
        
        for(int i = l1 - 1 ; i >= 0 ; i--) {
            for(int j = l2 - 1 ; j >= 0 ; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += result[i + j + 1];
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            
            sb.append(i);
        }

        return sb.toString();
    }
}

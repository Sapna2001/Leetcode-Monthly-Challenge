/*
Given two binary strings a and b, return their sum as a binary string.

Link: https://leetcode.com/problems/add-binary/
*/

class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        String result = "";
        int i = len1 - 1, j = len2 - 1, carry = 0;
        
        while(i >= 0 || j >= 0) {
            int val1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int val2 = (j >= 0) ? b.charAt(j) - '0' : 0; 
            int sum = val1 + val2 + carry;
            carry = sum / 2;
			result = (sum % 2) + result;
			i--;
			j--;
        }
        
        if(carry == 1) {
			result = carry + result;
		}
        
        return result;
    }
}

/*
Time Complexity : O(Max(a.length, b.length)
Space Complexity : O(a.length +b.length)
*/

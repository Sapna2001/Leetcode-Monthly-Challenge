/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Link: https://leetcode.com/problems/remove-k-digits/
*/

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<Character>();
        
        for(char ch : num.toCharArray()) {
            while(!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(!st.isEmpty() && k > 0) {
                st.pop();
                k--;
        }
    
        StringBuilder sb = new StringBuilder();
    
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    
        sb.reverse();
    
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
    
        return sb.length() > 0 ? sb.toString() : "0";
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

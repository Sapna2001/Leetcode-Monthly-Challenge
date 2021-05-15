/*
A valid number can be split up into these components (in order):
1. A decimal number or an integer.
2. (Optional) An 'e' or 'E', followed by an integer.
Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3744/
*/

class Solution {
    public boolean isNumber(String s) {
         if (s == null || s.trim().length() == 0) 
             return false; 
        
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        
        s = s.trim();
        for (int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch(c) {
                case '.':
                    if(dotSeen || eSeen)
                        return false;
                    dotSeen = true;
                    break;
                case 'E':
                case 'e':
                    if (eSeen || !numberSeen) 
                        return false;
                    eSeen = true;
                    numberSeen = false;
                    break;
               case '+':
               case '-':
                    if (i != 0 && s.charAt(i-1) != 'e') 
                        return false;
                    numberSeen = false;
                    break;
                default:
                    if (!isDigit(c))
                        return false;
                    numberSeen = true;
            }
        }
        return numberSeen;
    }
    
    boolean isDigit(Character c){
        return (c >= '0'  && c<='9');
    }
}

// TC : O(N)
// SC : O(1)

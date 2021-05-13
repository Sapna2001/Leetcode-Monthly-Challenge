/*
We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string s.  Return a list of strings representing all possibilities for what our original coordinates could have been.

Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3741/
*/

class Solution {
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1); // remove brackets
        List<String>result = new ArrayList<>();
        for(int i = 1 ; i < S.length() ; i++) {
            String leftSubString = S.substring(0,i);
            String rightSubString = S.substring(i, S.length());
            
            Set<String> leftParts = generateValidRepresentations(leftSubString);
            Set<String> rightParts = generateValidRepresentations(rightSubString);
            
            for(String leftPart : leftParts) 
                for(String rightPart : rightParts) 
                    result.add("("+leftPart+", "+rightPart+")");
            
            }
        
        return result;
        }
    
    public Set<String> generateValidRepresentations(String s) {
        int l = s.length();
        char[] characterSet = s.toCharArray();
        
        Set<String> possibleRepresentationsOfS = new HashSet<>();
        
        if(characterSet[0] == '0' && characterSet[l-1] == '0') {
            if(l == 1)
                possibleRepresentationsOfS.add("0");
            return possibleRepresentationsOfS;
        }
        
        if(characterSet[0] == '0') {
            possibleRepresentationsOfS.add("0." + s.substring(1));    
            return possibleRepresentationsOfS;
        }
            
        if(characterSet[l-1] == '0') {
            possibleRepresentationsOfS.add(s);    
            return possibleRepresentationsOfS;
        }
            
        for(int i = 1 ; i < l ; i++)
             possibleRepresentationsOfS.add(s.substring(0,i)+'.'+s.substring(i));   
        
        possibleRepresentationsOfS.add(s);    
        return possibleRepresentationsOfS;
    }
}

// TC : O(n3)
// SC : O(1)

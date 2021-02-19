/*
Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/
*/

/*
approach1 
TC : O(n)
SC : O(n)
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Character,Integer>> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c =='(' || c ==')') {
                if(stack.empty())
                    stack.push(new Pair<>(c,i));
                else {
                    if(c == ')' && stack.peek().getKey() == '(')
                        stack.pop();
                    else
                     stack.push(new Pair<>(c,i));   
                }
            }
        }
        
        Set<Integer> indexesToBeRemoved = new HashSet<>();
        while(!stack.empty()) {
            indexesToBeRemoved.add(stack.peek().getValue());
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <s.length() ; i++) {
            if(!indexesToBeRemoved.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}


/*
approach2
TC : O(n)
SC : O(1)
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        int closeBracket = 0;
        int openBracket = 0;
        
        for(char c : s.toCharArray()) {
            if(c == ')')
                closeBracket++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                closeBracket--;
                if(openBracket > 0) {
                    sb.append(c);
                    openBracket--;
                }
            } else if(c == '(') {
                if(closeBracket > openBracket) {
                    openBracket++;
                    sb.append(c);
                } 
            } else
              sb.append(c);  
        }
        return sb.toString();
    }
}

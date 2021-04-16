/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the 
deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.
*/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek().getKey() !=c)
                stack.push(new Pair<>(c, 1));
            else{
                Pair<Character, Integer> head = stack.pop();   
                stack.push(new Pair<>(head.getKey(), head.getValue()+1));
                if(stack.peek().getValue() == k)
                    stack.pop();
            }
            }
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<Character, Integer> head = stack.pop();
            int freq = head.getValue();
            while(freq-->0)
                answer.append(head.getKey());
        }
        return answer.reverse().toString();
        }      
}

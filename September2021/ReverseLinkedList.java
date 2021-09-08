/*
Reverse the linked list
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3966/
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, previous = null, next = null;
        
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
}

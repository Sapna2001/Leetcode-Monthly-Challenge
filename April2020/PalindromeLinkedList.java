/*
Given the head of a singly linked list, return true if it is a palindrome.

Link : - https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        // find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        // reverse
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) 
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

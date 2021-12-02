/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Link: https://leetcode.com/problems/odd-even-linked-list/
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;            
            odd.next = evenHead;
        }
        
        return head;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        return constructTree(head,null);
    }
    
    public TreeNode constructTree(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        
        if(head == tail) 
            return null;
        
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = constructTree(head,slow);
        root.right = constructTree(slow.next, tail);
        return root;
    }
}

// TC : O(n)

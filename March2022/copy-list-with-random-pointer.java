/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding
original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and 
copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Limk: https://leetcode.com/problems/copy-list-with-random-pointer/
*/

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        
        // Insert new nodes in the middle
        while(current != null) {
            Node temp = current.next;
            current.next = new Node(current.val);
            current.next.next = temp;
            current = temp;
        }
        
        current = head;
        
        // Set random pointers of new nodes
        while(current != null) {
            if(current.next != null) {
                current.next.random = current.random == null ? null : current.random.next;
            }
            current = current.next.next;
        }
        
        // Break linkings 
        Node original = head, copy = head.next;
        Node temp = copy;
        
        while(original != null && temp != null) {
            original.next = original.next.next;
            original = original.next;
            if(original != null) {
                temp.next = temp.next.next;
                temp = temp.next;   
            }
        }
        
        return copy;
    }
}

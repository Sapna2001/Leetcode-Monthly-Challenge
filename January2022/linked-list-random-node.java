/*
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:
- Solution(ListNode head) Initializes the object with the integer array nums.
- int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.

Link: https://leetcode.com/problems/linked-list-random-node/
*/

class Solution {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public Solution(ListNode head) {
        while(head != null) {
            this.arrayList.add(head.val);
            head = head.next;
        }    
    }
    
    public int getRandom() {
        int getNode = (int)(Math.random() * this.arrayList.size());
        return this.arrayList.get(getNode);
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

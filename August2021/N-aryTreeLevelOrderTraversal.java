/*
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3871/

TC: O(N)
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> NodeAtLevel = new ArrayList<>();
            while(size-- > 0) {
                Node head = queue.poll();
                NodeAtLevel.add(head.val);
                for(Node child : head.children)
                    queue.offer(child);
            }
            result.add(NodeAtLevel);
        }
        
        return result;
    }
}

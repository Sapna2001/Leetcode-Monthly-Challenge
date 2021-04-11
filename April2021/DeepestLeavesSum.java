/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3704/
*/

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sumOfCurrentLevel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sumOfCurrentLevel = 0;
            while(size-->0) {
                TreeNode head = queue.poll();
                sumOfCurrentLevel += head.val;
                if(head.left != null)
                    queue.offer(head.left);
                if(head.right != null)
                    queue.offer(head.right);
            }
        }
        return sumOfCurrentLevel;
    }
}
// TC: O(N)

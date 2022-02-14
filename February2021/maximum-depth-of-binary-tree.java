/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int result = 1 + Math.max(left, right);
        
        return result;
    }
}

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Link: https://leetcode.com/problems/diameter-of-binary-tree/
*/

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int currentDiameter = maxDepthOfTree(root.left) + maxDepthOfTree(root.right);
        
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
    
    public int maxDepthOfTree(TreeNode root) {
        if(root == null)
            return 0;
        
        return 1 + Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right));
    }
}

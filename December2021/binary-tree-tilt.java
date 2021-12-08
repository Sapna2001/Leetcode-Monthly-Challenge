/*
Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then 
the sum of the left subtree node values is treated as 0. The rule is similar if there the node does not have a right child.

Link: https://leetcode.com/problems/binary-tree-tilt/
*/

class Solution {
    private int totalTilt = 0;
    
    private int valueSum(TreeNode node) {
        if(node == null) {
            return 0;
        }    
        
        int leftSum = this.valueSum(node.left);
        int rightSum = this.valueSum(node.right);
        
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;
        
        return node.val + leftSum + rightSum; 
    }
    
    
    public int findTilt(TreeNode root) {
        this.totalTilt = 0;
        this.valueSum(root);
        return this.totalTilt;           
    }    
}

/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

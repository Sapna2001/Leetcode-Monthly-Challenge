/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3899/

TC: O(N)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int goodCount = 0;
    
    public int goodNodes(TreeNode root) {
        goodNodesHelperFunction(root, Integer.MIN_VALUE);
        return goodCount;
    }
    
    public void goodNodesHelperFunction(TreeNode root, Integer previousValue) {
        if(root == null) {
            return;
        }
        
        if(root.val >= previousValue) {
            goodCount++;
        }
        
        goodNodesHelperFunction(root.left, Math.max(root.val,previousValue));
        goodNodesHelperFunction(root.right, Math.max(root.val,previousValue));
        
        return;
    }
}

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Link: https://leetcode.com/problems/path-sum-iii/
*/

class Solution {
    private int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        
        helper(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        return result;
    }
    
    public void helper(TreeNode root, int sum) {
        if(root == null)
            return;
        
        if(sum == root.val)
            result++;
        
        sum -= root.val;
        
        helper(root.left, sum);
        helper(root.right, sum);
    }
}

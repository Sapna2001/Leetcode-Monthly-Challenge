/*
Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/
*/


class Solution {
    private long max = Integer.MIN_VALUE;    
    private long totalSum = ;  
    
    public int maxProduct(TreeNode root) {
        dfs(root);     
        calculateSubTreeSum(root);
        int result = (int)(max % ((int)Math.pow(10, 9) + 7));
        return result;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        totalSum += (long)root.val;
    }
    
    private long calculateSubTreeSum (TreeNode root) {
        if(root == null)
            return 0;
        long left = calculateSubTreeSum(root.left); 
        long right = calculateSubTreeSum(root.right);
        
        long subTreeSum = left + right + root.val;
        long currentProduct = subTreeSum * (totalSum - subTreeSum);
        max = Math.max(max, currentProduct);
        
        return subTreeSum;
    }
}


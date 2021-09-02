/*
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in 
any order.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3961/
*/

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);    
    }
    
    List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        if(start > end) {
            result.add(null);
            return result;
        }
        
        if(start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        
        for(int i = start ; i <= end ; i++) {
            List<TreeNode> leftTrees = helper(start, i-1);
            List<TreeNode> rightTrees = helper(i+1, end);
            
            for(TreeNode leftRoot : leftTrees) {
                for(TreeNode rightRoot : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}

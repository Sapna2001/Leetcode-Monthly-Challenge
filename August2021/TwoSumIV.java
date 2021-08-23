/*
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the 
given target.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/
*/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return pairExist(root, k, set);
    }
    
    public boolean pairExist(TreeNode root, int k, Set<Integer> set) {
        if(root == null)
            return false;
        
        if(set.contains(k - root.val))
            return true;
        
        set.add(root.val);
        
        return pairExist(root.left, k, set) || pairExist(root.right, k, set);
    }
}


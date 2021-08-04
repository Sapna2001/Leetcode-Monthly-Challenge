/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/
*/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root,targetSum,new ArrayList<Integer>(),paths);
        return paths;
    }
    
    public void findPaths(TreeNode root,int targetSum,List<Integer> currentPath,List<List<Integer>> paths) {
        if(root == null) {
            return;
        }
        currentPath.add(root.val);
        
        if(root.val == targetSum && root.left == null && root.right ==  null) {
            paths.add(currentPath);
            return;
        }
        
        findPaths(root.left,targetSum - root.val,new ArrayList<Integer>(currentPath),paths);
        findPaths(root.right,targetSum - root.val,new ArrayList<Integer>(currentPath),paths);
    }
}

/*
Given a binary tree, we install cameras on the nodes of the tree. 

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/
*/

class Solution {
    
    private int cameraCount = 0;
    
    private int needCamera = 0;
    private int hasCamera = 1;
    private int covered = 2;
    private int notNeeded = 3;
    
    public int minCameraCover(TreeNode root) {
        return getCameraStatusForNode(root) == needCamera ? cameraCount+1 : cameraCount;       
    }
    
    public int getCameraStatusForNode(TreeNode root) {
        if(root == null)
            return notNeeded;
        
        if(root.left == null && root.right == null)
            return needCamera;
        
        int leftStatus  = getCameraStatusForNode(root.left);
        int rightStatus = getCameraStatusForNode(root.right);
        
        if(leftStatus == needCamera || rightStatus == needCamera) {
             cameraCount++;
            return hasCamera;
        }
        
        if(leftStatus == hasCamera || rightStatus == hasCamera) 
            return covered;
        
        return needCamera;
    }
}

/*
The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3590/

*/

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null)
            return null;
        if(original==target)
            return cloned;
        TreeNode left = getTargetCopy(original.left,cloned.left,target);
        if(left!=null)
            return left;
        TreeNode right = getTargetCopy(original.right,cloned.right,target);
        if(right!=null)
            return right;
        return null;
    }
}

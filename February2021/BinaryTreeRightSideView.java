/*

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3630/

*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> answer = new ArrayList<>();
      findRightSideNos(root,answer,1);
      return answer;  
    }
    
    public void findRightSideNos(TreeNode node,List<Integer> answer,int level) {
        if(node==null)
            return;
        
        if(answer.size() < level) {
            answer.add(node.val);
        }
        
        findRightSideNos(node.right, answer, level + 1);
        findRightSideNos(node.left, answer, level + 1);
    }
}

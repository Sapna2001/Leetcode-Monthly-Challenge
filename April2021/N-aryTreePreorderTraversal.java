/*
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
*/

class Solution {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root==null) 
            return list;
        stack.push(root);
        while(!stack.empty()) {
            Node current = stack.pop();
            list.add(current.val);
            for(int i = current.children.size() - 1; i >= 0; i--) 
                stack.push(current.children.get(i));
        }
        return list;
    }
}

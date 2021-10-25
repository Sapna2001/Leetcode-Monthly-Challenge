/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

Link: https://leetcode.com/problems/min-stack/
*/

class MinStack {

    private Stack<int[]> stack = null;
    
    public MinStack() {
        stack = new Stack<>();    
    }
    
    public void push(int val) {
        if(!stack.isEmpty()){
			int[] top =  stack.peek();
			int min = Math.min(top[1], val);
			stack.push(new int[]{val, min});
		} else {
			stack.push(new int[]{val, val});
		}   
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
			stack.pop();
		}    
    }
    
    public int top() {
        int[] top =  stack.peek();
		return top[0];    
    }
    
    public int getMin() {
        int[] top =  stack.peek();
		return top[1];     
    }
}

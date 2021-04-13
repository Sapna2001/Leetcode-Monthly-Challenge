/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to 
flatten it.
Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3706/
*/

public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack = new Stack<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList == null)
            return;
        for(int i = nestedList.size() - 1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();    
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger top = stack.peek();
            if(top.isInteger())
                return true;
            else {
                stack.pop();
                for(int i = top.getList().size() - 1; i >= 0; i--)
                    stack.push(top.getList().get(i));
            }       
        }  
        return false;
    }
}

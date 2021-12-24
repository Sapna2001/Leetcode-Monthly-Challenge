/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover 
all the intervals in the input.

Link: https://leetcode.com/problems/merge-intervals/
*/

class Solution {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));    
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0 ; i < intervals.length ; i++) {
            int[] currentInterval = intervals[i];
            if(!stack.isEmpty()) {
                int[] topInterval = stack.peek();
                if(topInterval[1] >= currentInterval[0]) {
                    stack.pop();
                    int startPoint = topInterval[0];
                    int endPoint = Math.max(topInterval[1], currentInterval[1]);
                    stack.push(new int[]{startPoint, endPoint});
                    } else {
                        stack.push(currentInterval);
                    }
             } else {
                        stack.push(currentInterval);
             }
        }
        
        int[][] result = new int[stack.size()][2];
        int count = stack.size() - 1;
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            result[count][0] = top[0];
            result[count--][1] = top[1];                      
        }
        
        return result;
    }
}

/*
Time Complexity: O(nlogn)
Space Complexity: O(n)
*/

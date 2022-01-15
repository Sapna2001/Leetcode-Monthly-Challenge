/*
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:
- i + 1 where: i + 1 < arr.length.
- i - 1 where: i - 1 >= 0.
- j where: arr[i] == arr[j] and i != j.

Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Link: https://leetcode.com/problems/jump-game-iv/
*/

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        if(n <= 1) {
            return 0;
        }
        
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            hashMap.putIfAbsent(arr[i],new ArrayList<Integer>());
            hashMap.get(arr[i]).add(i); 
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.add(0);
        visited[0] = true;
        int step = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int index = queue.poll();
                if(index == n-1) {
                    return step;
                }
                
                for(int indexValue : hashMap.get(arr[index])) { 
                    if(!visited[indexValue]) {
                        queue.add(indexValue);
                        visited[indexValue] = true;
                    }
                }
                
                hashMap.get(arr[index]).clear();

                
                if(index + 1 < n && !visited[index + 1]) {      
                        queue.add(index + 1);
                        visited[index + 1] = true;
                }
                
                if(index - 1 >= 0 && !visited[index - 1]) {
                        queue.add(index - 1);
                        visited[index - 1] = true;
                }
                  
            }
            
            step++;
        }

        return -1;
    }
}

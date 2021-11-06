/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        int[] result = new int[2];
        
        for(int num : nums){
            if(set.contains(num)) {
                set.remove(num);    
            } else {
                set.add(num);    
            }
        }
        
        Object[] arr = set.toArray();
        
        result[0] = (int)arr[0];
        result[1] = (int)arr[1];
        
        return result;
    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            int indexTobeNegated = Math.abs(nums[i]) - 1;
            if(nums[indexTobeNegated] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[indexTobeNegated] = -nums[indexTobeNegated];
            }
            
        }
        return result;
    }
}


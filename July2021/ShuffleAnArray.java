/*
Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the 
shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3820/

Fisher yates algorithm
TC: O(n)
SC: O(1)
*/

class Solution {

    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;    
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] randomArray = nums.clone();
        for(int i = nums.length - 1 ; i > 0 ; i--) {
            int j = random.nextInt(i+1);
            swap(randomArray ,i,j);
        }
        return randomArray;
    }
    
    public void swap(int[] randomArray , int i, int j) {
        int temp = randomArray[i];
        randomArray[i] = randomArray[j];
        randomArray[j] = temp;
    }
}

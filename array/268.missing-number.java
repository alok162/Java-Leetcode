// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1:

// Input: [3,0,1]
// Output: 2

class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = nums.length*(nums.length + 1)/2;
        int arraySum = 0;
        for (int i=0; i<nums.length; i++) {
            arraySum += nums[i];
        }
        return totalSum - arraySum;
    }
}

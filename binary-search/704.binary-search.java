// Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


// Example 1:

// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4


class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target)
                return mid;
            if (target >= nums[start] && target <= nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}

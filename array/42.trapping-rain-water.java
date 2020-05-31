// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6

class Solution {
    public int trap(int[] height) {
        int ans = 0, left = 0, level = 0, right = height.length-1;
        while (left < right) {
            int lower = height[height[left] < height[right] ? left ++ : right --];
            level = Math.max(lower, level);
            ans += level - lower;
        }
        return ans;
    }
}x

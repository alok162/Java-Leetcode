// Given a 32-bit signed integer, reverse digits of an integer.

// Example 1:

// Input: 123
// Output: 321
// Example 2:

// Input: -123
// Output: -321
    
// Note:
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

class Solution {
    public int reverse(int x) {
        int ans = 0;
        int y = Math.abs(x);
        while (y > 0) {
            int rem = y % 10;
            y /= 10;
            if((ans * 10)/10 != ans)
                return 0;
            ans = (ans * 10) + rem;
        }
        return x < 0 ? -ans : ans;
    }
}

// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

// Example 1:

// Input: 121
// Output: true
// Example 2:

// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int palinNumber = 0;
        while (y > 0) {
            int rem = y % 10;
            palinNumber = (palinNumber * 10) + rem;
            y /= 10;
        }
        if (palinNumber == x)
            return true;
        return false;
    }
}

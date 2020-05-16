// Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

// B.length >= 3
// There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
// (Note that B could be any subarray of A, including the entire array A.)

// Given an array A of integers, return the length of the longest mountain. 

// Return 0 if there is no mountain.

// Example 1:

// Input: [2,1,4,7,3,2,5]
// Output: 5
// Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

class Solution {
    public int longestMountain(int[] A) {
        int i = 1, increase = 0, decrease = 0, result = 0, j = 0;
        
        while (i < A.length) {
            j = i;
            increase = 0;
            while (i < A.length - 1 && A[i-1] < A[i]) {
                increase ++;
                i ++;
            }
            
            decrease = 0;
            while (i < A.length && A[i-1] > A[i]) {
                decrease ++;
                i ++;
            }
            
            if (i == j)
                i ++;
            if (increase > 0 && decrease > 0)
                result = Math.max(result, increase + decrease + 1);
        }
        return result;
    }
}

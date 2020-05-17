// Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

// Example 1:

// Input: A = [4,5,0,-2,-3,1], K = 5
// Output: 7
// Explanation: There are 7 subarrays with a sum divisible by K = 5:
// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int currSum = 0, result = 0;
        hm.put(0, 1);
        for (int i = 0; i < A.length; i ++) {
            currSum += A[i];
            int remainder = currSum % K;
            if (remainder < 0)
                remainder += K;
            if (hm.containsKey(remainder)) {
                result += hm.get(remainder);
                hm.put(remainder, hm.get(remainder) + 1);
            } else
                hm.put(remainder, 1);
        }
        return result;
    }
}

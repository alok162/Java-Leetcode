// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:

// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

class Solution {
    public int[][] generateMatrix(int n) {
        int m = n;
        int k = 0, l = 0;
        int[][] ans = new int[n][n];
        int val = 1;
        while (k < m && l < n) {
            
            for (int i = l; i < n; i ++) {
                ans[k][i] = val;
                val ++;
            }
            
            k ++;
            for (int i = k; i < m; i ++) {
                ans[i][n-1] = val;
                val ++;
            }
            
            n --;
            if (k < m) {
                for (int i = n-1; i >= l; i --) {
                    ans[m-1][i] = val;
                    val ++;
                }
                m --;
            }
            
            if (l < n) {
                for (int i = m-1; i >= k; i --) {
                    ans[i][l] = val;
                    val ++;
                }
                l ++;
            }
        }
        return ans;
    }
}

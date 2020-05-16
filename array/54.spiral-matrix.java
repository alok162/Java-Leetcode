// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// Example 1:

// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int k = 0;
        int l = 0;
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;
        List<Integer> arr = new ArrayList<Integer>();
        
        while (k < m && l < n) {
            for (int i = l; i < n; i++)
                arr.add(matrix[k][i]);
            
            k ++;
            for (int j = k; j < m; j++)
                arr.add(matrix[j][n-1]);
            
            n --;
            if (k < m) {
                for (int i = n-1; i >= l; i--)
                    arr.add(matrix[m-1][i]);
                m --;
            }
            
            if (l < n) { 
                for (int i = m-1; i >= k; i--)
                    arr.add(matrix[i][l]);
                l ++;
            }
        }
        return arr;
    }
}

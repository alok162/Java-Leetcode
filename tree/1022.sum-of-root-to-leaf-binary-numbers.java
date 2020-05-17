Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

Example 1:

             1
       0           1
    0     1     0      1
                
Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = {0};
        sumUtil(root, 0, sum);
        return sum[0];
    }
    
    private void sumUtil(TreeNode root, int currSum, int[] sum) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            sum[0] += (currSum * 2 + root.val);
        sumUtil(root.left, (currSum * 2 + root.val), sum);
        sumUtil(root.right, (currSum * 2 + root.val), sum);
    }
}

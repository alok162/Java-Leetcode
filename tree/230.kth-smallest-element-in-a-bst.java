// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note:
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Example 1:

// Input: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// Output: 1


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
    TreeNode ans = null;
    int tempK;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        tempK = k;
        kthSmallestUtil(root);
        return ans.val;
    }
    
    private void kthSmallestUtil(TreeNode root) {
        if (root == null) return;
        kthSmallestUtil(root.left);
        if (tempK == 1) {
            ans = root;
        }
        tempK--;
        kthSmallestUtil(root.right);
    }
}

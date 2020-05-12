// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// Note: A leaf is a node with no children.

// Example:

// Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
// Return:

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        pathSumUtil(root, sum, combination, ans);
        return ans;
    }
    
    private void pathSumUtil(TreeNode root, int sum, ArrayList<Integer> combination,          List<List<Integer>> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum-root.val == 0) {
            combination.add(root.val);
            ans.add(new ArrayList<Integer>(combination));
            combination.remove(combination.size() - 1);
        }
        combination.add(root.val);
        pathSumUtil(root.left, sum-root.val, combination, ans);
        pathSumUtil(root.right, sum-root.val, combination, ans);
        combination.remove(combination.size() - 1);
    }
}

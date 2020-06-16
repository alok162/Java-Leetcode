// Given a binary tree, return all root-to-leaf paths.

// Note: A leaf is a node with no children.

// Example:

// Input:

//    1
//  /   \
// 2     3
//  \
//   5

// Output: ["1->2->5", "1->3"]

// Explanation: All root-to-leaf paths are: 1->2->5, 1->3

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, "", ans);
        return ans;
    }
    
    private void helper(TreeNode root, String str, List<String> ans) {
        if (root != null && root.left == null && root.right == null) {
            if (str.length() == 0)
                str += String.valueOf(root.val);
            else
                str += "->" + String.valueOf(root.val);
            ans.add(str);
        }
        
        if (root == null) return;
        
        if (str.length() == 0)
            str += String.valueOf(root.val);
        else
            str += "->" + String.valueOf(root.val);
        
        helper(root.left, str, ans);
        helper(root.right, str, ans);
    }
}

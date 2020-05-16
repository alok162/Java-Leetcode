// Example 1:
// Input:
//      1
//     /
//    2
// Output:
// [["", "1", ""],
//  ["2", "", ""]]
// Example 2:
// Input:
//      1
//     / \
//    2   3
//     \
//      4
// Output:
// [["", "", "", "1", "", "", ""],
//  ["", "2", "", "", "", "3", ""],
//  ["", "", "4", "", "", "", ""]]


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
    public List<List<String>> printTree(TreeNode root) {
        int row = maxHeight(root);
        int col = (int)Math.pow(2, row) - 1;
        
        List<List<String>> ans = new ArrayList<>();
        List<String> rowList = new ArrayList<>();
        
        for (int i = 0; i < col; i ++) {
            rowList.add("");
        }
        
        for (int i = 0; i < row; i ++) {
            ans.add(new ArrayList<>(rowList));
        }
        createList(root, 0, col, 0, ans);
        return ans;
    }
    
    private void createList(TreeNode root, int low, int high, int level, List<List<String>> ans) {
        if (root == null) return;
        int mid = (low + high)/2;
        ans.get(level).set(mid, Integer.toString(root.val));
        createList(root.left, low, mid-1, level + 1, ans);
        createList(root.right, mid + 1, high, level + 1, ans);
    }
    
    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
}

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        
        inorder(root1, root1List);
        inorder(root2, root2List);
        
        return checkSequence(root1List, root2List);
    }
    
    private boolean checkSequence(List<Integer> arr1, List<Integer> arr2) {
        if (arr1.size() != arr2.size()) return false;
        
        for (int index = 0; index < arr1.size(); index ++) {
            if (arr1.get(index) != arr2.get(index))
                return false;
        }
        return true;
    }
    
    private void inorder(TreeNode root,  List<Integer> arr) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            arr.add(root.val);
            return;
        }
        inorder(root.left, arr);
        inorder(root.right, arr);
    }
}

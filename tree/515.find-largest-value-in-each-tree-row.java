// You need to find the largest value in each row of a binary tree.

// Example:
// Input: 

//           1
//          / \
//         3   2
//        / \   \  
//       5   3   9 

// Output: [1, 3, 9]

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> arr = new ArrayList<Integer>();
        if (root == null) return arr;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (q.size() > 0) {
            int n = q.size(), max = Integer.MIN_VALUE;
            while (n > 0) {
                TreeNode temp = q.remove();
                if (temp.val > max)
                    max = temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                n --;
            }
            arr.add(max);
        }
        return arr;
    }
}

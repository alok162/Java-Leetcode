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
class QNode {
    TreeNode node;
    int index;
    public QNode (TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Queue<QNode> q = new LinkedList<>();
        q.add(new QNode(root, 0));
        
        while (q.size() > 0) {
            int n = q.size();
            int startIndex = q.peek().index;
            while (n-- > 0) {
                QNode temp = q.remove();
                int currIndex = temp.index;
                if (temp.node.left != null)
                    q.add(new QNode(temp.node.left, 2 * currIndex));
                if (temp.node.right != null)
                    q.add(new QNode(temp.node.right, 2 * currIndex + 1));
                ans = Math.max(ans, currIndex - startIndex + 1);
            }
        }
        return ans;
    }
}

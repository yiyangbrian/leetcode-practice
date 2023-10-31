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
    private boolean isValid = true;
    private TreeNode prev;

    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        if(prev != null && isValid) {
            isValid = root.val > prev.val;
        }
        prev = root;
        dfs(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }
}

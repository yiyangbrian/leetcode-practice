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
    private List<Integer> nodeValues = new ArrayList<>();

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        dfs(node.left);
        nodeValues.add(node.val);
        dfs(node.right);
    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);

        int minDifference = Integer.MAX_VALUE;
        for(int i = 1; i < nodeValues.size(); i ++) {
            minDifference = Math.min(minDifference, nodeValues.get(i) - nodeValues.get(i - 1));
        }

        return minDifference;

    }
}

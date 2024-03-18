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

    int rootToLeaf = 0;

    private void preorder(TreeNode node, int currentSum) {

        if(node != null) {
            currentSum = currentSum * 10 + node.val;
            if(node.left == null && node.right == null) {
                rootToLeaf += currentSum;
            }
            preorder(node.left, currentSum);
            preorder(node.right, currentSum);
        }

    }


    public int sumNumbers(TreeNode root) {

        preorder(root, 0);
        return rootToLeaf;

    }
}

import java.util.ArrayDeque;

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
    public void flatten(TreeNode root) {
        if(root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        stack.push(root);

        while(stack.size() > 0) {
            TreeNode curr = stack.pop();
            if(curr.right != null) {
                stack.push(curr.right);
            }
            if(curr.left != null) {
                stack.push(curr.left);
            }

            queue.add(curr);
        }

        int size = queue.size();
        TreeNode p = queue.poll();

        for(int i = 1; i < size; i ++) {

            p.left = null;
            p.right = queue.poll();
            p = p.right;
        }
    }
}
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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        Map<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        int sum = 0;
        stack.push(root);
        map.put(root, root.val);

        while(stack.size() > 0) {
            TreeNode current = stack.pop();

            if(current.left == null && current.right == null) {
                sum += map.get(current);
                continue;
            }

            if(current.left != null) {
                map.put(current.left, map.get(current) * 10 + current.left.val);
                stack.push(current.left);
            }

            if(current.right != null) {
                map.put(current.right, map.get(current) * 10 + current.right.val);
                stack.push(current.right);
            }
        }

        return sum;
    }
}

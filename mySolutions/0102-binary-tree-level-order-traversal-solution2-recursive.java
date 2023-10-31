import java.util.ArrayList;
import java.util.List;

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
    private List<List<Integer>> list = new ArrayList<>();

    private void recurse(TreeNode root, int layer) {
        if(root == null) return;

        if(layer == list.size()) {
            ArrayList<Integer> level = new ArrayList<>();
            level.add(root.val);
            list.add(level);
        } else {
            list.get(layer).add(root.val);
        }

        recurse(root.left, layer + 1);
        recurse(root.right, layer + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        recurse(root, 0);
        return list;
    }
}

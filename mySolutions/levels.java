import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        List<List<Integer>> levels = new ArrayList<>();

        if(root == null) return levels;

        queue.offer(root);
        int layer = 0;

        while(!queue.isEmpty()) {

            int levelLength = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelLength; i ++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            if(layer % 2 != 0) {
                Collections.reverse(level);
            }

            levels.add(level);
            layer ++;
        }

        return levels;
    }
}

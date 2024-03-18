import java.util.ArrayDeque;
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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Double> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            double sum = 0;
            for(int i = 0; i < levelLength; i ++) {

                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            list.add(sum / levelLength);
        }
        return list;
    }
}

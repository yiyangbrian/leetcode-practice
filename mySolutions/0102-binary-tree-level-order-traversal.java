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
    public List<List<Integer>> levelOrder(TreeNode root) {


        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        queue.offer(root);

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

            list.add(level);
        }

        return list;


    }
}

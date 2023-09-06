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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) {
            return new ArrayList<Integer>();
        }

        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.addLast(new Pair<TreeNode, Integer>(root, 0));
        List<Integer> ans = new ArrayList<>();

        while(queue.size() > 0) {

            Pair<TreeNode, Integer> current = queue.removeFirst();
            TreeNode node = current.getKey();
            int layer = current.getValue();

            if(node.left != null) {
                queue.addLast(new Pair<TreeNode, Integer>(node.left, layer + 1));
            }
            if(node.right != null) {
                queue.addLast(new Pair<TreeNode, Integer>(node.right, layer + 1));
            }

            if(queue.size() == 0 || layer != queue.peek().getValue()) {
                ans.add(node.val);
            }
        }

        return ans;
    }
}

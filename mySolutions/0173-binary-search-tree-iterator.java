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
class BSTIterator {
    private Deque<TreeNode> deque;

    private void addToDeque(TreeNode root) {
        if(root == null) {
            return;
        }
        addToDeque(root.left);
        deque.addLast(root);
        addToDeque(root.right);
    }

    public BSTIterator(TreeNode root) {
        deque = new ArrayDeque<>();
        addToDeque(root);
    }

    public int next() {
        return deque.removeFirst().val;

    }

    public boolean hasNext() {
        return deque.size() != 0;

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

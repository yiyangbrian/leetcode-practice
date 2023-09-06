/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static int BOTH_PENDING = 2;
    private static int LEFT_DONE = 1;
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();

        deque.push(new Pair<TreeNode, Integer>(root, BOTH_PENDING));

        boolean oneNodeFound = false;

        TreeNode LCA = null;

        TreeNode child = null;

        while(!deque.isEmpty()) {

            Pair<TreeNode, Integer> top = deque.peek();
            TreeNode parent = top.getKey();
            int parentState = top.getValue();

            if(parentState != BOTH_DONE) {

                if(parentState == BOTH_PENDING) {

                    if(parent == p || parent == q) {

                        if(oneNodeFound) {
                            return LCA;
                        } else {
                            oneNodeFound = true;
                            LCA = parent;
                        }
                    }

                    child = parent.left;
                } else {
                    child = parent.right;
                }

                deque.pop();
                deque.push(new Pair<TreeNode, Integer>(parent, parentState - 1));

                if(child != null) {
                    deque.push(new Pair<TreeNode, Integer>(child, BOTH_PENDING));
                }


            } else {

                if(LCA == deque.pop().getKey() && oneNodeFound) {
                    LCA = deque.peek().getKey();
                }
            }
        }

        return null;
    }
}

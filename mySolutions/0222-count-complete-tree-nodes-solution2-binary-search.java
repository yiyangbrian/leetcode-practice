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
    private int layer(TreeNode root) {
        int layer = 0;
        while(root != null) {
            root = root.left;
            layer ++;
        }
        return layer;
    }

    private boolean nodeExists(int layer, int index, TreeNode root) {

        int left = 0;
        int right = (int)Math.pow(2, layer - 1) - 1;
        int middle;

        for(int i = 0; i < layer - 1; i ++) {
            middle = left + (right - left) / 2;
            if(index <= middle) {
                root = root.left;
                right = middle;
            }
            else {
                root = root.right;
                left = middle + 1;
            }
        }

        return root != null;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int layer = layer(root);
        System.out.println(layer);
        if(layer == 1) return 1;

        int left = 0;
        int right = (int)Math.pow(2, layer - 1) - 1;
        int middle = 0;

        while(left <= right) {
            middle = left + (right - left) / 2;
            if(nodeExists(layer, middle, root)) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return (int)Math.pow(2, layer - 1) + right;
    }
}

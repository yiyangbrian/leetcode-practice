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
    private void average(TreeNode root, int layer, List<Double> sum, List<Integer> count) {
        if(root == null) {
            return;
        }
        if(layer == sum.size()) {
            sum.add(1.0 * root.val);
            count.add(1);
        } else {
            sum.set(layer, sum.get(layer) + root.val);
            count.set(layer, count.get(layer) + 1);
        }
        average(root.left, layer + 1, sum, count);
        average(root.right, layer + 1, sum, count);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for(int i = 0; i < res.size(); i ++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }
}
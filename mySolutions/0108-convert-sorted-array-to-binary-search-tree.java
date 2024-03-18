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
    private TreeNode recurse(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        if(start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode left = recurse(nums, start, middle - 1);
        TreeNode right = recurse(nums, middle + 1, end);
        TreeNode node = new TreeNode(nums[middle]);
        node.left = left;
        node.right = right;
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }
}

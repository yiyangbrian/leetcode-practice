import java.util.Map;

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
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if(postLeft > postRight || inLeft > inRight) {
            return null;
        }

        int rootVal = postorder[postRight];
        int index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(postorder, postLeft, postLeft + index - 1 - inLeft, inorder, inLeft, index - 1);
        root.right = buildTree(postorder, postRight - inRight + index, postRight - 1, inorder, index + 1, inRight);

        return root;
    }
}
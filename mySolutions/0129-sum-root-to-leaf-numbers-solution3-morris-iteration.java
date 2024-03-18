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
    public int sumNumbers(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        int steps;
        TreeNode predecessor;

        while(root != null) {

            if(root.left != null) {
                predecessor = root.left;
                steps = 1;
                while(predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps ++;
                }

                // set link predecessor.right = root
                // and go to explore the left subtree
                if(predecessor.right == null) {
                    currNumber = currNumber * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                }

                // break the link predecessor.right = root
                // once the link is broken
                // it's time to change subtree and go to the right
                else {

                    if(predecessor.left == null) {
                        rootToLeaf += currNumber;
                    }

                    for(int i = 0; i < steps; i ++) {
                        currNumber /= 10;
                    }

                    predecessor.right = null;
                    root = root.right;

                }
            }

            // If there is no left child
            // then just go right
            else {

                currNumber = currNumber * 10 + root.val;

                if(root.right == null) {
                    rootToLeaf += currNumber;
                }
                root = root.right;
            }

        }

        return rootToLeaf;
    }
}

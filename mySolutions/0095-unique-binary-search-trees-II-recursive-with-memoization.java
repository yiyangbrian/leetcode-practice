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
    public List<TreeNode> allPossibleBST(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> memo) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        if(memo.containsKey(new Pair<>(start, end))) {
            return memo.get(new Pair<>(start, end));
        }
        for(int i = start; i <= end; i ++) {

            List<TreeNode> leftTrees = allPossibleBST(start, i - 1, memo);
            List<TreeNode> rightTrees = allPossibleBST(i + 1, end, memo);

            for(TreeNode leftTree : leftTrees) {
                for(TreeNode rightTree : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftTree;
                    currTree.right = rightTree;
                    res.add(currTree);
                }
            }
        }
        memo.put(new Pair<>(start, end), res);
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        return allPossibleBST(1, n, memo);
    }
}

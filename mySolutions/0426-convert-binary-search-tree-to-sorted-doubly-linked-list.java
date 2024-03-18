/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return root;
        }

        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);

        if(leftHead == null && rightHead == null) {
            root.left = root;
            root.right = root;
            return root;
        }

        if(leftHead == null && rightHead != null) {
            root.right = rightHead;
            Node rightEnd = rightHead.left;

            rightHead.left = root;
            root.left = rightEnd;
            root.left.right = root;

            return root;
        }

        if(leftHead != null && rightHead == null) {
            Node leftEnd = leftHead.left;
            leftHead.left = root;
            root.right = leftHead;
            root.left = leftEnd;
            root.left.right = root;

            return leftHead;
        }


        leftHead.left.right = root;
        root.left = leftHead.left;

        root.right = rightHead;

        Node end = rightHead.left;

        rightHead.left = root;
        leftHead.left = end;
        leftHead.left.right = leftHead;

        return leftHead;
    }
}

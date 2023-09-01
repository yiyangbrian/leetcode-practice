import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while(queue.size() != 0) {

            int size = queue.size();

            while(size > 0) {

                Node cur = queue.removeFirst();
                size --;

                if(size == 0) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }

                if(cur.left != null) {
                    queue.add(cur.left);
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        return root;
    }
}

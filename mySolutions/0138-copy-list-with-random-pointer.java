import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    Map<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        if(visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        Node node = new Node(head.val);

        visitedHash.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}

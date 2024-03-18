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
    Map<Node, Node> nodeHash = new HashMap<>();

    private Node getClonedNode(Node node) {
        if(node == null) {
            return null;
        }
        if(nodeHash.containsKey(node)) {
            return nodeHash.get(node);
        }
        nodeHash.put(node, new Node(node.val));
        return nodeHash.get(node);
    }

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        Node oldNode = head;

        Node newNode = new Node(oldNode.val);
        nodeHash.put(oldNode, newNode);

        while(oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return nodeHash.get(head);
    }
}

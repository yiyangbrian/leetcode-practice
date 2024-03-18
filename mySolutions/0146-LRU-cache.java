import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class LRUCache {

    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node prev = map.get(key);
        Node curr = prev.next;
        moveToTail(curr);

        return curr.val;
    }

    private void moveToTail(Node curr) {
        if(curr == tail) {
            return;
        }

        Node prev = map.get(curr.key);
        Node post = curr.next;

        tail.next = curr;
        map.put(curr.key, tail);
        prev.next = post;
        map.put(post.key, prev);
        curr.next = null;
        tail = curr;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            Node node = new Node(key, value);
            tail.next = node;
            map.put(key, tail);
            tail = node;
            if(capacity > 0) {
                capacity --;
            } else {
                Node first = head.next;
                deleteNode(first);
            }
        } else {
            Node prev = map.get(key);
            Node curr = prev.next;
            curr.val = value;
            moveToTail(curr);
        }
    }

    private void deleteNode(Node curr) {
        Node prev = map.get(curr.key);
        if(curr == tail) {
            prev.next = null;
            map.remove(curr.key);
        } else {
            Node post = curr.next;
            prev.next = post;
            map.put(post.key, prev);
            map.remove(curr.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

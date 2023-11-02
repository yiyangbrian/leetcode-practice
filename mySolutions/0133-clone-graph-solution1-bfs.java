/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>(); // node: copy
        Set<Node> visited = new HashSet<>();

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, new Node(node.val));
        visited.add(node);


        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            Node copy = map.get(cur);

            for(Node neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                }
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
                copy.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
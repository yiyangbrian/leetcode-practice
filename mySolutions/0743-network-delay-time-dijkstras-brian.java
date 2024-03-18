import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    class Node {
        int node;
        int dist;
        boolean visited;
        Map<Integer, Integer> neighbors;

        public Node(int node, int dist, boolean visited) {
            this.node = node;
            this.dist = dist;
            this.visited = visited;
            this.neighbors = new HashMap<Integer, Integer>();
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        Node[] nodes = new Node[n + 1];
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        for(int i = 1; i <= n; i ++) {
            if(k == i) {
                nodes[i] = new Node(k, 0, true);
                pq.add(nodes[i]);
            } else {
                nodes[i] = new Node(i, Integer.MAX_VALUE, false);
                pq.add(nodes[i]);
            }
        }

        for(int[] time : times) {
            Node cur = nodes[time[0]];
            cur.neighbors.put(time[1], time[2]);
        }


        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            Map<Integer, Integer> destinations = cur.neighbors;
            for(Map.Entry<Integer, Integer> destination : destinations.entrySet()) {
                int time = destination.getValue();
                int node = destination.getKey();
                if(nodes[node].visited == false && cur.dist + time < nodes[node].dist) {
                    nodes[node].dist = cur.dist + time;
                    pq.remove(nodes[node]);
                    pq.add(nodes[node]);
                }
            }
            cur.visited = true;
        }

        int minTime = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i ++) {
            minTime = Math.max(nodes[i].dist, minTime);
        }

        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}

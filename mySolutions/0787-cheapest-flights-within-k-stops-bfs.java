import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            graph.put(i, new HashMap<Integer, Integer>());
        }
        for(int[] flight : flights) {
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Deque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{src, 0});

        int count = 0;

        while(count < k + 1 && !pq.isEmpty()) {
            int size = pq.size();
            for(int i = 0; i < size; i ++) {
                int[] cur = pq.poll();
                int node = cur[0];
                int dist = cur[1];

                Map<Integer, Integer> neighbors = graph.get(node);
                for(int neighbor : neighbors.keySet()) {
                    int price = neighbors.get(neighbor);
                    if(price + dist < distance[neighbor]) {
                        distance[neighbor] = price + dist;
                        pq.add(new int[]{neighbor, distance[neighbor]});
                    }
                }
            }
            count ++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i ++) {
            map.put(i, new HashMap<>());
        }
        for(int[] time : times) {
            Map<Integer, Integer> destinations = map.get(time[0]);
            destinations.put(time[1], time[2]);
        }

        int[] visited = new int[n + 1]; // 1 -> visited
        int count = 0;

        int[] parent = new int[n + 1]; // shortest path yet
        int[] dist = new int[n + 1]; // shortest distance yet

        parent[k] = k;
        dist[k] = 0;

        for(int i = 1; i <= n; i ++) {
            if(i != k) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(k);

        while(!queue.isEmpty()) {
            int source = queue.poll();
            for(Map.Entry<Integer, Integer> destination : map.get(source).entrySet()) {
                int dest = destination.getKey();
                int time = destination.getValue();
                if(dist[source] + time < dist[dest]) {
                    dist[dest] = dist[source] + time;
                    parent[dest] = source;
                    queue.offer(dest);
                }
                // if(visited[dest] == 0) {
                //     queue.offer(dest);
                // }
            }
            visited[source] = 1;
            count ++;
        }

        int minTime = 0;

        for(int i = 1; i <= n; i ++) {
            if(visited[i] == 0) {
                return -1;
            }
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime;
    }
}
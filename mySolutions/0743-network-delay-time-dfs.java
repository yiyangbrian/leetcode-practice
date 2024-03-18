import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> graph;

    private void dfs(int node, int[] dist, int curTime) {
        if(curTime >= dist[node]) {
            return;
        }
        dist[node] = curTime;
        if(graph.get(node).size() == 0) {
            return;
        }
        for(Pair<Integer, Integer> neighbor : graph.get(node)) {
            int dest = neighbor.getKey();
            int time = neighbor.getValue();

            dfs(dest, dist, dist[node] + time);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        this.graph = new HashMap<>();
        for(int i = 1; i < n + 1; i ++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] time : times) {
            graph.get(time[0]).add(new Pair(time[1], time[2]));
        }

        for(int node : graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a.getValue() - b.getValue());
        }

        int[] dist = new int[n + 1];
        for(int i = 1; i < n + 1; i ++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dfs(k, dist, 0);

        int minTime = Integer.MIN_VALUE;

        for(int i = 1; i < n + 1; i ++) {
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime == Integer.MAX_VALUE ? -1 : minTime;

    }
}

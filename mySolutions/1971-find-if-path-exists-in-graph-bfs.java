import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        boolean[] visited = new boolean[n];
        visited[source] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == destination) return true;


            for(int neighbor : map.get(cur)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true; // marking nodes before enter to next layer significantly reduces time
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}

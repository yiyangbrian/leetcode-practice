import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Integer, Set<Integer>> map;

    private boolean dfs(int source, int destination, boolean[] visited) {
        if(source == destination) {
            return true;
        }
        for(int neighbor : map.get(source)) {
            if(!visited[neighbor]) {
                visited[neighbor] = true;
                if(dfs(neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.computeIfAbsent(a, val -> new HashSet<>()).add(b);
            map.computeIfAbsent(b, val -> new HashSet<>()).add(a);
        }

        boolean[] visited = new boolean[n];
        visited[source] = true;

        return dfs(source, destination, visited);
    }
}

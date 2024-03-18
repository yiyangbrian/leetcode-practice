import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    int[][] edges;
    int[] status;
    Map<Integer, Set<Integer>> map;

    private boolean dfs(int source, int destination) {
        if(source == destination) {
            return true;
        }
        if(status[source] != -1) {
            return status[source] == 1;
        }
        status[source] = 0;
        Set<Integer> neighbors = map.get(source);
        if(source != destination && neighbors.size() == 0) {
            return false;
        }
        for(int neighbor : neighbors) {
            if(!dfs(neighbor, destination)) {
                return false;
            }
        }
        status[source] = 1;
        return true;
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        this.map = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            map.put(i, new HashSet<>());
        }
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        if(map.get(destination).size() > 0) return false;

        this.edges = edges;
        // -1: unprocessed, 0: undecided, 1: processed and valid
        this.status = new int[n];
        Arrays.fill(status, -1);

        return dfs(source, destination);

    }
}

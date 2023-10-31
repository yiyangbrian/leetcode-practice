import java.util.*;

class Solution {
    Map<Integer, Set<Integer>> map;
    int count;

    private boolean dfs(int node, int[] status) {
        Set<Integer> neighbors = map.get(node);

        status[node] = 0;

        for(int neighbor : neighbors) {
            if(status[neighbor] == 1) {
                return false;
            } else if(status[neighbor] == -1) {
                if(!dfs(neighbor, status)) {
                    return false;
                }
            }
        }
        status[node] = 1;
        count ++;
        return true;
    }

    public boolean validTree(int n, int[][] edges) {

        // adjacency list
        map = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            map.put(i, new HashSet<>());
        }
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        // status[i] == -1, 0, 1 -> unprocessed, in process, processed
        int[] status = new int[n];
        Arrays.fill(status, -1);

        count = 0;
        boolean acyclic = dfs(0, status);

        return acyclic && count == n;
    }
}

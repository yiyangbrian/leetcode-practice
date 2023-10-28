import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> paths;
    int[][] graph;

    private void backtrack(int i, List<Integer> path) {
        if(i == graph.length - 1) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        for(int neighbor : graph[i]) {
            path.add(neighbor);
            backtrack(neighbor, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(0, path);
        return paths;
    }
}

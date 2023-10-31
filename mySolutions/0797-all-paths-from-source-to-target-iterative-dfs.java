import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();

        List<Integer> path = new ArrayList<>();

        if(graph.length == 0 || graph == null) {
            paths.add(path);
            return paths;
        }
        int target = graph.length - 1;
        path.add(0);
        stack.push(path);

        while(!stack.isEmpty()) {
            List<Integer> current = stack.pop();
            int[] neighbors = graph[current.get(current.size() - 1)];
            for(int neighbor : neighbors) {
                List<Integer> newPath = new ArrayList(current);
                newPath.add(neighbor);
                if(neighbor == target) {
                    paths.add(newPath);
                } else {
                    stack.push(newPath);
                }
            }
        }

        return paths;
    }
}

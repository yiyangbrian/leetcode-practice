import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int destination = graph.length - 1;

        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new LinkedList<>();
        path.add(0);
        queue.offer(path);

        while(!queue.isEmpty()) {

            List<Integer> curPath = queue.poll();
            int tail = curPath.get(curPath.size() - 1);
            for(int neighbor : graph[tail]) {
                List<Integer> newPath = new LinkedList<>(curPath);
                newPath.add(neighbor);
                if(neighbor == destination) {
                    ans.add(newPath);
                } else {
                    queue.offer(newPath);
                }
            }

        }

        return ans;
    }
}

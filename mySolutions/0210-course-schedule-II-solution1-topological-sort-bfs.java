import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        int indegree[] = new int[numCourses];
        List<List<Integer>> neighbors = new LinkedList<>();

        for(int i = 0; i < numCourses; i ++) {
            neighbors.add(new ArrayList<Integer>());
        }

        for(int[] prerequisite : prerequisites) {
            neighbors.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]] ++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i ++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;

        while(!queue.isEmpty()) {
            int root = queue.poll();
            res[nodesVisited] = root;
            nodesVisited ++;

            for(int neighbor : neighbors.get(root)) {
                indegree[neighbor] --;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if(nodesVisited < numCourses) {
            return new int[0];
        }

        return res;
    }
}

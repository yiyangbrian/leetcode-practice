import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> nextLevel = new ArrayList<>(numCourses);

        for(int i = 0; i < numCourses; i ++) {
            nextLevel.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            nextLevel.get(prerequisite[1]).add(prerequisite[0]);
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
            nodesVisited ++;

            for(int neighbor : nextLevel.get(root)) {
                indegree[neighbor] --;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}

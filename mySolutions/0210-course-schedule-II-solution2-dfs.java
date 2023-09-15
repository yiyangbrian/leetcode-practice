import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible = true;
    Map<Integer, Integer> color = new HashMap<>();
    Map<Integer, List<Integer>>adjList = new HashMap<>();
    List<Integer> topologicalOrder = new ArrayList<>();

    private void dfs(int node) {
        if(!isPossible) {
            return;
        }
        color.put(node, GRAY);
        for(Integer neighbor : adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if(color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if(color.get(neighbor) == GRAY) {
                isPossible = false;
            }
        }
        color.put(node, BLACK);
        topologicalOrder.add(node);
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i ++) {
            color.put(i, WHITE);
        }

        for(int i = 0; i < prerequisites.length; i ++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            // .getOrDefault() in case adjList has not been initiated for src

            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        for(int i = 0; i < numCourses; i ++) {
            if(color.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;

        if(isPossible) {
            order = new int[numCourses];
            for(int i = 0; i < numCourses; i ++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;

    }
}

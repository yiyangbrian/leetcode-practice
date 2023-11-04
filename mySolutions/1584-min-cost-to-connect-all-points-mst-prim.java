import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int[][] points;
    int n;

    private int manhattan(int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    private void addEdges(int i, Queue<int[]> edges, int[] visited) {
        for(int j = 0; j < n; j ++) {
            if(visited[j] == 0 && j != i) {
                int[] edge = new int[]{i, j};
                edges.add(edge);
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {

        this.points = points;
        this.n = points.length;
        int[] visited = new int[n];

        Queue<int[]> edges = new PriorityQueue<>((a, b) -> manhattan(a[0], a[1]) - manhattan(b[0], b[1]));

        // add points[0] outgoings into edges
        // set visited[0] as 1

        addEdges(0, edges, visited);
        visited[0] = 1;

        int count = 0;
        int cost = 0;

        while(count < n - 1) {
            int[] edge = edges.poll();
            while(visited[edge[1]] == 1) {
                edge = edges.poll();
            }
            int cur = edge[0];
            int next = edge[1];
            int dist = manhattan(cur, next);

            visited[next] = 1;
            cost += dist;
            count ++;
            addEdges(next, edges, visited);
        }

        return cost;
    }
}

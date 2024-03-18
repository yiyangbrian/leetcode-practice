import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int n = rows * columns;
        int[][] visited = new int[rows][columns];
        int[][] distances = new int[rows][columns];

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> distances[a / columns][a % columns] - distances[b / columns][b % columns]);

        pq.offer(0);
        for(int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        distances[0][0] = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while(!pq.isEmpty()) {
            int curNode = pq.poll();
            int row = curNode / columns, col = curNode % columns;
            visited[row][col] = 1;

            for(int[] direction : directions) {
                int i = row + direction[0];
                int j = col + direction[1];
                int idx = i * columns + j;

                if(i >= 0 && i < rows && j >= 0 && j < columns && visited[i][j] == 0) {
                    int curEffort = Math.abs(heights[row][col] - heights[i][j]);
                    int curMaxEffort = Math.max(curEffort, distances[row][col]);
                    if(curMaxEffort < distances[i][j]) {
                        distances[i][j] = curMaxEffort;
                        pq.remove(idx);
                        pq.offer(idx);
                    }
                }
            }
        }

        return distances[rows - 1][columns - 1];
    }
}

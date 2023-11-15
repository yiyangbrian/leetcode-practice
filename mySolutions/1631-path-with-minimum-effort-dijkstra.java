import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        int[][] effort = new int[rows][columns];
        int[][] visited = new int[rows][columns];

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> effort[a / columns][a % columns] - effort[b / columns][b % columns]);

        for(int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        pq.add(0);

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!pq.isEmpty()) {
            int cur = pq.poll();

            int row = cur / columns;
            int column = cur % columns;

            visited[row][column] = 1;
            int curValue = heights[row][column];

            for(int[] direction : directions) {
                // neighbor -> heights[i][j];
                int i = row + direction[0];
                int j = column + direction[1];
                int idx = i * columns + j;

                if(i >= 0 && i < rows && j >= 0 && j < columns && visited[i][j] != 1) {

                    int neighborValue = heights[i][j];
                    int curEffort = Math.abs(curValue - neighborValue);
                    int maxEffort = Math.max(curEffort, effort[row][column]);

                    if(maxEffort < effort[i][j]) {
                        effort[i][j] = maxEffort;
                        if(pq.contains(idx)) {
                            pq.remove(idx);
                        }
                        pq.add(idx);
                    }
                }
            }
        }

        return effort[rows - 1][columns - 1];
    }
}

class Solution {
    int[][] heights;
    int res = Integer.MAX_VALUE;
    int rows, columns;

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int backtrack(int row, int col, int[][] visited, int maxEffort) {

        if(row == rows - 1 && col == columns - 1) {
            res = Math.min(res, maxEffort);
            return maxEffort;
        }
        visited[row][col] = 1;
        int minEffort = Integer.MAX_VALUE;
        for(int[] direction : directions) {
            int i = row + direction[0];
            int j = col + direction[1];

            if(i >= 0 && i < rows && j >= 0 && j < columns && visited[i][j] == 0) {

                int curEffort = Math.abs(heights[row][col] - heights[i][j]);
                int maxCurrentEffort = Math.max(maxEffort, curEffort);
                if(maxCurrentEffort < res) {
                    int result = backtrack(i, j, visited, maxCurrentEffort);
                    minEffort = Math.min(minEffort, result);
                }
            }
        }
        visited[row][col] = 0;
        return minEffort;
    }

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.rows = heights.length;
        this.columns = heights[0].length;
        int[][] visited = new int[rows][columns];
        return backtrack(0, 0, visited, 0);
    }
}
class Solution {
    char[][] matrix;
    int[][] memo;
    int m;
    int n;

    private int dp(int row, int col) {
        if(row == m || col == n || matrix[row][col] == '0') {
            memo[row][col] = 0;
            return 0;
        }
        if(memo[row][col] == -1) {
            int pre = dp(row + 1, col + 1);
            int valid = 0;
            for(int i = 1; i <= pre; i ++) {
                if(matrix[row + i][col] == '1' && matrix[row][col + i] == '1') {
                    valid += 1;
                } else {
                    break;
                }
            }
            memo[row][col] = valid + 1;
        }
        return memo[row][col];
    }


    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i ++) {
            for(int j = 0; j < n + 1; j ++) {
                memo[i][j] = -1;
            }
        }
        for(int i = m; i >= 0; i --) {
            for(int j = n; j >= 0; j --) {
                dp(i, j);
            }
        }
        int max = 0;
        for(int i = 0; i < m + 1; i ++) {
            for(int j = 0; j < n + 1; j ++) {
                max = Math.max(max, memo[i][j]);
            }
        }
        return max * max;
    }
}

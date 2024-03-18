class Solution {

    int[] houses;
    int[][] cost;
    int n;
    int[][][] memo; // m * n * target

    private int dp(int i, int color, int neighbor) {
        if(i == 0) {
            if(neighbor == 0) {
                if(houses[0] == 0) {
                    return cost[i][color];
                } else {
                    return 0;
                }
            } else {
                return 1000001;
            }
        }

        if(neighbor < 0) {
            return 1000001;
        }


        if(memo[i][color][neighbor] == -1) {

            // house is painted
            if(houses[i] != 0) {

                if(houses[i - 1] != 0) {
                    memo[i][color][neighbor] = houses[i] == houses[i - 1] ? dp(i - 1, color, neighbor) : dp(i - 1, color, neighbor - 1);

                } else {
                    int min = Integer.MAX_VALUE;
                    for(int c = 0; c < n; c ++) {
                        if(c == houses[i] - 1) {
                            min = Math.min(min, dp(i - 1, c, neighbor));
                        } else {
                            min = Math.min(min, dp(i - 1, c, neighbor - 1));
                        }
                    }
                    memo[i][color][neighbor] = min;
                }
            }

            // house is not painted
            else {
                if(houses[i - 1] != 0) {
                    memo[i][color][neighbor] = color == houses[i - 1] - 1 ? dp(i - 1, color, neighbor) + cost[i][color] : dp(i - 1, color, neighbor - 1) + cost[i][color];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int c = 0; c < n; c ++) {
                        if(c == color) {
                            min = Math.min(min, dp(i - 1, c, neighbor));
                        } else {
                            min = Math.min(min, dp(i - 1, c, neighbor - 1));
                        }
                    }
                    memo[i][color][neighbor] = min + cost[i][color];
                }
            }
        }
        return memo[i][color][neighbor];

    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.n = n;

        memo = new int[m][n][target]; // house id - color - neighbors

        for(int i = 0; i < m; i ++) {
            for(int j = 0 ; j < n; j ++) {
                for(int k = 0; k < target; k ++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int c = 0; c < n; c ++) {
            min = Math.min(min, dp(m - 1, c, target - 1));
        }

        return min < 1000001 ? min : -1;
    }
}

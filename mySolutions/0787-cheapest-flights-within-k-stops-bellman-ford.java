import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        // <destination : <indegree source : price>>

        for(int i = 0; i < n; i ++) {
            map.put(i, new HashMap<Integer, Integer>());
        }
        for(int[] flight : flights) {
            map.get(flight[1]).put(flight[0], flight[2]);
        }

        int[][] memo = new int[k + 2][n];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        memo[0][src] = 0;

        for(int row = 1; row < k + 2; row ++) {
            for(int col = 0; col < n; col ++) {
                memo[row][col] = memo[row - 1][col];
                Map<Integer, Integer> indegrees = map.get(col);
                for(Map.Entry<Integer, Integer> indegree : indegrees.entrySet()) {
                    int source = indegree.getKey();
                    int price = indegree.getValue();

                    if(memo[row - 1][source] != Integer.MAX_VALUE) {
                        memo[row][col] = Math.min(memo[row][col], memo[row - 1][source] + price);
                    }
                }
            }
        }

        return memo[k + 1][dst] == Integer.MAX_VALUE ? -1 : memo[k + 1][dst];

    }
}
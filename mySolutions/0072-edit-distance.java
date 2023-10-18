class Solution {
    String word1;
    String word2;
    int[][] memo;

    private int dp(int p1, int p2) {
        if(p1 == 0) {
            return p2;
        }
        if(p2 == 0) {
            return p1;
        }
        if(memo[p1][p2] == -1) {
            if(word1.charAt(p1 - 1) != word2.charAt(p2 - 1)) {
                int delete = dp(p1 - 1, p2);
                int insert = dp(p1, p2 - 1);
                int replace = dp(p1 - 1, p2 - 1);
                memo[p1][p2] = Math.min(delete, Math.min(insert, replace)) + 1;
            } else {
                memo[p1][p2] = dp(p1 - 1, p2 - 1);
            }
        }
        return memo[p1][p2];
    }


    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;

        int n1 = word1.length();
        int n2 = word2.length();
        memo = new int[n1 + 1][n2 + 1];
        for(int i = 0; i < n1 + 1; i ++) {
            for(int j = 0; j < n2 + 1; j ++) {
                memo[i][j] = -1;
            }
        }
        return dp(n1, n2);
    }
}

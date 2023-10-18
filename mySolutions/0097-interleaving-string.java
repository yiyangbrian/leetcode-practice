class Solution {
    String s1, s2, s3;
    int n1, n2, n3;
    int[][] memo;

    private boolean dp(int p1, int p2) {
        if(p1 == n1) {
            return s3.substring(p1 + p2).equals(s2.substring(p2));
        }
        if(p2 == n2) {
            return s3.substring(p1 + p2).equals(s1.substring(p1));
        }
        if(memo[p1][p2] == -1) {
            char curr = s3.charAt(p1 + p2);
            if(curr == s1.charAt(p1) && dp(p1 + 1, p2) || curr == s2.charAt(p2) && dp(p1, p2 + 1)) {
                memo[p1][p2] = 1;
            } else {
                memo[p1][p2] = 0;
            }
        }
        return memo[p1][p2] == 1;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();
        if(n3 != n1 + n2) return false;

        memo = new int[n1][n2];

        for(int i = 0; i < n1; i ++) {
            for(int j = 0; j < n2; j ++) {
                memo[i][j] = -1;
            }
        }
        return dp(0, 0);
    }
}

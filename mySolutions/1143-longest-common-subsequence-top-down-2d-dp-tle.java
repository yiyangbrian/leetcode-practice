class Solution {

    String text1;
    String text2;
    int n;
    int m;
    int memo[][];

    private int dp(int i, int j) {
        if(i == n || j == m) return 0;
        if(memo[i][j] == 0) {
            if(text1.charAt(i) == text2.charAt(j)) {
                memo[i][j] = 1 + dp(i + 1, j + 1);
            } else {
                memo[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
            }
        }
        return memo[i][j];
    }


    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        n = text1.length();
        m = text2.length();
        memo = new int[n][m];
        return dp(0, 0);
    }
}

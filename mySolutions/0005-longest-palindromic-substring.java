class Solution {
    String s;
    int n;
    int[][] memo;

    private int dp(int i, int d) {
        if(i == 0 || d == 0) {
            memo[i][d] = 1;
            return 1;
        }
        if(d == 1 && s.charAt(i) == s.charAt(i - 1)) {
            memo[i][d] = 2;
            return 2;
        }
        if(memo[i][d] == 0) {
            if(s.charAt(i - d) == s.charAt(i) && dp(i - 1, d - 2) == d - 1) {
                memo[i][d] = dp(i - 1, d - 2) + 2;
            } else {
                memo[i][d] = dp(i, d - 1);
            }
        }
        return memo[i][d];
    }

    public String longestPalindrome(String s) {
        this.s = s;
        n = s.length();
        memo = new int[n][n];

        for(int i = 0; i < n; i ++) {
            dp(i, i);
        }
        int max = 0;
        int point = 0;
        int len = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++)
                if(memo[i][j] > max) {
                    max = memo[i][j];
                    point = i;
                    len = j;
                }
        }

        return s.substring(point - len, point + 1);
    }
}

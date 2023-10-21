import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    String s;
    int[] memo;
    Set<String> set = new HashSet<>();

    private int dp(int i) {
        if(i == 0) return 1;
        if(i == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        if(memo[i] == -1) {

            if(set.contains(s.substring(i - 2, i))) {
                if(s.charAt(i - 1) == '0') {
                    memo[i] = dp(i - 2);
                } else {
                    memo[i] = dp(i - 1) + dp(i - 2);
                }
            } else {
                memo[i] = dp(i - 1);
            }
        }
        return memo[i];
    }

    public int numDecodings(String s) {

        this.s = s;
        int n = s.length();
        for(int i = 1; i < n; i ++) {
            if(s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                return 0;
            }
        }
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        for(int i = 1; i <= 26; i ++) {
            set.add(Integer.toString(i));
        }
        return dp(n);
    }
}

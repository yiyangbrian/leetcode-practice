import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<String> set = new HashSet<>();

    private boolean recurse(String s, int start, int minLen) {
        if(start >= s.length()) return true;

        for(int i = start + minLen; i <= s.length(); i ++) {
            String curr = s.substring(start, i);
            if(set.contains(curr) && recurse(s, i, minLen)) {
                return true;
            }
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int minLen = Integer.MAX_VALUE;
        for(String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            set.add(word);
        }
        return recurse(s, 0, minLen);
    }
}
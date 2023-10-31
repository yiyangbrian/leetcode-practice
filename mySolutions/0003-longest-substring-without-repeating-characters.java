import java.util.HashSet;
import java.util.Set;

class Solution {
    private boolean containsDuplicates(String substring) {
        Set<Character> chars = new HashSet<>();
        for(int i = 0; i < substring.length(); i ++) {
            if(chars.contains(substring.charAt(i))) {
                return true;
            } else {
                chars.add(substring.charAt(i));
            }
        }
        return false;
    }


    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < s.length()) {
            if(containsDuplicates(s.substring(left, right + 1))) {
                left ++;
                right ++;
            } else {
                right ++;
                ans ++;
            }
        }

        return ans;
    }
}

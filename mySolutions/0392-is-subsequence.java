class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }

        int i = 0;
        int j = 0;
        char curChar = s.charAt(i);

        while(i < s.length() && j < t.length()) {
            if(t.charAt(j) == s.charAt(i)){
                i ++;
            }
            j ++;
        }

        if(j <= t.length() && i == s.length()){
            return true;
        }

        return false;
    }
}

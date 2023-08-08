class Solution {
    public int lengthOfLastWord(String s) {

        s = s.trim();
        int n = s.length() - 1;
        int length = 0;

        while(n >= 0 && s.charAt(n) != ' ') {
            length += 1;
            n -= 1;
        }
        return length;
    }
}

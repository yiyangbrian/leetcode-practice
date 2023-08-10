class Solution {
    public int strStr(String haystack, String needle) {

        int index = -1;
        int i = 0;

        while(i + needle.length() <= haystack.length()) {
            if(haystack.substring(i, i + needle.length()).equals(needle)) {
                index = i;
                break;
            } else {
                i ++;
            }
        }

        return index;
    }
}
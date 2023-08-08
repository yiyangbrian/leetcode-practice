class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int i = 0;

        while(i < strs[0].length()) {

            int j = 1;

            while(j < strs.length) {
                if(
                        strs[j] == null ||
                                strs[j].length() < i + 1 ||
                                strs[j].charAt(i) != strs[0].charAt(i)) {

                    break;
                } else {
                    j += 1;
                }
            }

            if(j != strs.length) {
                break;
            } else {
                prefix += strs[0].charAt(i);
                i += 1;
            }
        }

        return prefix;
    }
}

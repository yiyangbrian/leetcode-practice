class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int charsInSection = 2 * (numRows - 1);

        for(int i = 0; i < numRows; i ++) {
            int j = i;

            if(i == 0 || i == numRows - 1) {

                while(j < s.length()) {
                    sb.append(s.charAt(j));
                    j += 2 * (numRows - 1);
                }
            } else {

                while(j < s.length()){
                    sb.append(s.charAt(j));
                    if(j % (2 * numRows - 2) < numRows) {
                        j += 2 * numRows - 2 * i - 2;
                    } else {
                        j += 2 * i;
                    }
                }
            }
        }

        return sb.toString();
    }
}

class Solution {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        s = s.toLowerCase();

        while(left < right) {

            while(!Character.isLetterOrDigit(s.charAt(left)) &&
                    left < s.length() - 1) {
                left ++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right)) &&
                    right > 0) {
                right --;
            }

            if(!Character.isLetterOrDigit(s.charAt(left)) ||
                    !Character.isLetterOrDigit(s.charAt(right))) {
                return true;
            }

            if(s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            } else {
                return false;
            }
        }

        return true;
    }
}

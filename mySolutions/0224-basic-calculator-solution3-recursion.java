class Solution {
    int i;

    public int calculate(String s) {

        int operand = 0;
        int result = 0; // on-going result
        int sign = 1; // 1 means positive, -1 means negative

        while(i < s.length()) {

            char ch = s.charAt(i);

            i ++;

            if(ch == ' ' || Character.isDigit(ch)) {
                operand = (ch == ' ') ? operand : 10 * operand + (ch - '0');
            } else if(ch == '(') {
                operand  = calculate(s);
            } else if(ch == ')') {
                break;
            } else {
                result += sign * operand;
                sign = ch == '+' ? 1 : -1;
                operand = 0;
            }
        }

        return result + sign * operand;
    }
}

import java.util.Stack;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();

        int operand = 0;
        int result = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i ++) {

            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {

                // Forming operand
                operand = 10 * operand + (int) (ch - '0');

            } else if(ch == '+') {

                result += sign * operand;
                sign = 1;
                operand = 0;

            } else if(ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if(ch == '(') {

                stack.push(result);
                stack.push(sign);

                // the sign before '(' has been stored in stack, new evaluation begins for sub-expression
                sign = 1;
                result = 0;

            } else if(ch == ')') {

                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;

            }
        }

        // + (sign * operand) applies to expression ending with no closing parenthesis.
        return result + (sign * operand);
    }
}

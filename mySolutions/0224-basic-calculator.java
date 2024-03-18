import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    private Set<Character> operators = new HashSet<>() {{
        add('+');
        add('-');
        add('(');
        add(')');
    }};

    private void processInnerParentheses(Stack<String> stack) {
        String temp = stack.pop();
        int currentNum = 0;
        int sum = 0;
        while(!temp.equals("(")) {

            //in consider of negative numbers
            if(!operators.contains(temp.charAt(0))
                    || (operators.contains(temp.charAt(0))
                    && temp.length() > 1)) {

                currentNum = Integer.valueOf(temp);
                sum += currentNum;
            } else if(temp.equals("-")) {
                sum -= currentNum * 2;
            }
            temp = stack.pop();
        }

        //push the result in parentheses
        stack.push(Integer.toString(sum));
    }

    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        s = "(" + s + ")";

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {

            if(operators.contains(s.charAt(i))) {

                //process the calculation inside close parentheses
                if(s.charAt(i) == ')') {
                    processInnerParentheses(stack);

                    //push in '(', '+' or '-'
                } else {
                    stack.push(s.substring(i, i + 1));
                }

                //push numbers of multiple digits
            } else {
                int j = i;
                while(j < s.length()
                        && !operators.contains(s.charAt(j))) {
                    j ++;
                }
                stack.push(s.substring(i, j));
                i = j - 1;
            }
        }

        return Integer.valueOf(stack.pop());
    }
}

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(!OPERATIONS.containsKey(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int number2 = stack.pop();
                int number1 = stack.pop();
                BiFunction<Integer, Integer, Integer> operation = OPERATIONS.get(token);
                int result = operation.apply(number1, number2);
                stack.push(result);
            }
        }

        return stack.pop();
    }
}

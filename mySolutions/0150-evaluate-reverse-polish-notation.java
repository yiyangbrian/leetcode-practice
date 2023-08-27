import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        Set<String> operators = new HashSet<>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};

        for(int i = 0; i < tokens.length; i ++) {
            if(!operators.contains(tokens[i])) {
                deque.addLast(Integer.parseInt(tokens[i]));
            } else if(deque.size() >= 2) {
                int intFirst = deque.removeLast();
                int intSecond = deque.removeLast();
                if(tokens[i].equals("+")) deque.addLast(intSecond + intFirst);
                if(tokens[i].equals("-")) deque.addLast(intSecond - intFirst);
                if(tokens[i].equals("*")) deque.addLast(intSecond * intFirst);
                if(tokens[i].equals("/")) deque.addLast(intSecond / intFirst);
            }
        }
        return deque.removeLast();
    }
}

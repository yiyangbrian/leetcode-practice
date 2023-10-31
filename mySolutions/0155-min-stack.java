import java.util.Stack;

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> sortStack;

    public MinStack() {
        mainStack = new Stack<>();
        sortStack = new Stack<>();
        sortStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        mainStack.push(val);
        sortStack.push(Math.min(sortStack.peek(), val));
    }

    public void pop() {
        mainStack.pop();
        sortStack.pop();

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return sortStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

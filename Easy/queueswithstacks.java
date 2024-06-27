import java.util.Stack;

class MyQueue {
    Stack<Integer> main;
    Stack<Integer> helper;
    public MyQueue() {
        this.main = new Stack<>();
        this.helper = new Stack<>();
    }
    
    public void push(int x) {
        if (!this.main.isEmpty()) {
            while (!main.isEmpty()) {
                int temp = main.pop();
                helper.add(temp);
            }
            main.add(x);
            while (!helper.isEmpty()) {
                int t = helper.pop();
                main.add(t);
            }
        } else {
            main.add(x);
        }
    }
    
    public int pop() {
        return main.pop();
    }
    
    public int peek() {
        return main.peek();

    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}
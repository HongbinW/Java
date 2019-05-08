import java.util.Stack;

class LRUCache {

    /** initialize your data structure here. */
    private Stack<Integer> data;
    private Stack<Integer> min;
    public LRUCache() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.peek() < x){
            min.push(min.peek());
        }else{
            min.push(x);
        }
    }

    public void pop() {
        if(data.isEmpty()){
            return;
        }
        min.pop();
        data.pop();
    }

    public int top() {
        if(data.isEmpty()){
            throw new RuntimeException("The stack is Empty");
        }
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        LRUCache minStack = new LRUCache();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
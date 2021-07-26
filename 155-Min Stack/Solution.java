class MinStack {
    Stack<Integer> stack;
    Queue<Integer> heap;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        heap = new PriorityQueue<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        heap.add(val);
    }

    public void pop() {
        heap.remove(stack.peek());
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return heap.peek();
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
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st;
    // Stack<Integer> minSt;
    
    public MinStack() {
        st = new Stack<Integer>();
        // minSt = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if (minSt.isEmpty() || minSt.peek() >= x)
            minSt.push(x);
    }
    
    public void pop() {
        if (minSt.peek().equals(st.pop()))
            minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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

//Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Example:

// MyStack stack = new MyStack();

// stack.push(1);
// stack.push(2);  
// stack.top();   // returns 2
// stack.pop();   // returns 2
// stack.empty(); // returns false


class MyStack {
    Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<Integer>(); 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int size = que.size();
        que.add(x);
        for (int i = 0; i < size; i ++) 
            que.add(que.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return que.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return que.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
         return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

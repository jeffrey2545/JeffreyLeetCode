class MyStack {
    Queue<Integer> trueQueue;
    Queue<Integer> tmpQueue;
    

    public MyStack() {
        trueQueue = new LinkedList<>();
        tmpQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        trueQueue.offer(x);
    }
    
    public int pop() {
        int result = 0;
        while (!trueQueue.isEmpty()) {
            result = trueQueue.poll();
            if (trueQueue.isEmpty()) {
                break;
            }
            tmpQueue.offer(result);
        }
        // int result = trueQueue.poll();
        // tmpQueue.offer(result);
        Queue<Integer> queue = new LinkedList<>();
        trueQueue = tmpQueue;
        tmpQueue = queue;
        return result;
    }
    
    public int top() {
        int result = 0;
        while (!trueQueue.isEmpty()) {
            result = trueQueue.poll();
            tmpQueue.offer(result);
        }
        // int result = trueQueue.poll();
        // tmpQueue.offer(result);
        Queue<Integer> queue = new LinkedList<>();
        trueQueue = tmpQueue;
        tmpQueue = queue;
        return result;
    }
    
    public boolean empty() {
        if (trueQueue.isEmpty()) {
            return true;
        } else {
            return false;
        }
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
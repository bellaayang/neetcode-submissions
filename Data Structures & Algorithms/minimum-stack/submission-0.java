class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int value) {
        stack.add(value);
        if (!minStack.isEmpty()) {
            int minVal = minStack.get(minStack.size() - 1);
            if (minVal < value) {
                minStack.add(minVal);
            } else {
                minStack.add(value);
            }
        } else {
            minStack.add(value);
        }
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
        if (!minStack.isEmpty()) {
            minStack.remove(minStack.size() - 1);
        }
        
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
        
    }
    
    public int getMin() {
      
        return minStack.get(minStack.size() - 1);
       

        
        
    }
}
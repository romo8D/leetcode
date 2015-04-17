#Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

#push(x) -- Push element x onto stack.
#pop() -- Removes the element on top of the stack.
#top() -- Get the top element.
#getMin() -- Retrieve the minimum element in the stack.

class MinStack:
    def __init__(self):
        self.stack = [];
        self.minStack = [];
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stack.append(x);
        if not self.minStack or x <= self.minStack[-1]:
            self.minStack.append(x);

    # @return nothing
    def pop(self):
        t = self.stack.pop();
        if self.minStack and t == self.minStack[-1]:
           self.minStack.pop(); 

    # @return an integer
    def top(self):
        return self.stack[-1];

    # @return an integer
    def getMin(self):
        return self.minStack[-1];

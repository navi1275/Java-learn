package leetcode.editor.cn;
 
//实现一个MyQueue类，该类用两个栈来实现一个队列。 示例： MyQueue queue = new MyQueue(); queue.push(1); 
//queue.push(2); queue.peek();  // 返回 1 queue.pop();   // 返回 1 queue.empty(); // 返
//回 false 说明： 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty
// 操作是合法的。 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 假设所有操作都是有效的 
//（例如，一个空的队列不会调用 pop 或者 peek 操作）。 Related Topics 栈 
// 👍 33 👎 0

import java.util.Stack;

/**
 * LC面试题0304化栈为队
 * 2021-03-24 14:48:00
 */
public class LC面试题0304化栈为队{
    public static void main(String[] args) {
//          Solution solution = new LC面试题0304化栈为队().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {

        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    private void transfer(){
        while (!inStack.empty()){
            outStack.push(inStack.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.empty()){
            transfer();
        }
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(outStack.empty()){
            transfer();
        }
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
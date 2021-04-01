package leetcode.editor.cn;
 
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 842 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * LC155最小栈
 * 2021-03-18 20:59:00
 */
public class LC155最小栈{
    public static void main(String[] args) {
//          Solution solution = new LC155最小栈().new Solution();
        MinStack minStack = new LC155最小栈().new MinStack();
minStack.push(2147483646);
minStack.push(2147483646);
minStack.push(2147483647);
minStack.top();      //--> 返回 0.
minStack.pop();
minStack.getMin();   //--> 返回 -3.
minStack.pop();
minStack.getMin();   //--> 返回 -3.
minStack.pop();
minStack.push(2147483647);
minStack.top();      //--> 返回 0.
minStack.getMin();   //--> 返回 -2.
    }
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
        List<Integer> data;
        int top = -1;
    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
    }
    
    public void push(int val) {
        data.add(val);
        top += 1;
    }
    
    public void pop() {
        top -= 1;
    }
    
    public int top() {
        return data.get(top);
    }
    
    public int getMin() {
        int ret = data.get(0);
        for (int i = 1; i <= top; i++) {
            ret = Math.min(data.get(i), ret);
        }
        return ret;
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
//leetcode submit region end(Prohibit modification and deletion)

}
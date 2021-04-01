package leetcode.editor.cn;
 
//请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。 
//
// 请你完成 FrontMiddleBack 类： 
//
// 
// FrontMiddleBack() 初始化队列。 
// void pushFront(int val) 将 val 添加到队列的 最前面 。 
// void pushMiddle(int val) 将 val 添加到队列的 正中间 。 
// void pushBack(int val) 将 val 添加到队里的 最后面 。 
// int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// 
//
// 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说： 
//
// 
// 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。 
// 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", 
//"popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
//[[], [1], [2], [3], [4], [], [], [], [], []]
//输出：
//[null, null, null, null, null, 1, 3, 4, 2, -1]
//
//解释：
//FrontMiddleBackQueue q = new FrontMiddleBackQueue();
//q.pushFront(1);   // [1]
//q.pushBack(2);    // [1, 2]
//q.pushMiddle(3);  // [1, 3, 2]
//q.pushMiddle(4);  // [1, 4, 3, 2]
//q.popFront();     // 返回 1 -> [4, 3, 2]
//q.popMiddle();    // 返回 3 -> [4, 2]
//q.popMiddle();    // 返回 4 -> [2]
//q.popBack();      // 返回 2 -> []
//q.popFront();     // 返回 -1 -> [] （队列为空）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= val <= 109 
// 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。 
//
// 
// Related Topics 设计 链表 
// 👍 5 👎 0

public class LC1670设计前中后队列20210316{
    public static void main(String[] args) {
//          Solution solution = new LC1670设计前中后队列20210316().new Solution();

FrontMiddleBackQueue q = new LC1670设计前中后队列20210316().new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushFront(2);   // [1]
q.pushFront(3);   // [1]
q.pushFront(4);   // [1]
        System.out.println(q.popBack());      // 返回 2 -> []

        System.out.println(q.popBack());      // 返回 2 -> []

        System.out.println(q.popBack());      // 返回 2 -> []

        System.out.println(q.popBack());      // 返回 2 -> []


        q.pushBack(2);    // [1, 2]
q.pushMiddle(3);  // [1, 3, 2]
q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // 返回 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // 返回 3 -> [4, 2]
        System.out.println(q.popMiddle());    // 返回 4 -> [2]
        System.out.println(q.popBack());      // 返回 2 -> []
        System.out.println(q.popFront());     // 返回 -1 -> [] （队列为空）
    }


    class CircularDeque {
        ListNode head = null;
        ListNode tail = null;
        int count=0;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public CircularDeque() {
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.pre = head;

        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            ListNode node = new ListNode(value);
            ListNode next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;
            count++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            ListNode node = new ListNode(value);
            ListNode pre = tail.pre;
            pre.next = node;
            node.pre = pre;
            tail.pre = node;
            node.next = tail;
            count++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            head.next = head.next.next;
            head.next.pre = head;
            count--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            count--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return head.next.val;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return tail.pre.val;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count == 0;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class FrontMiddleBackQueue {
    CircularDeque preDeque;
    CircularDeque nextDeque;

    public FrontMiddleBackQueue() {
        preDeque = new CircularDeque();
        nextDeque = new CircularDeque();
    }

    private void refresh(){
        if(nextDeque.count - preDeque.count > 1){
            int front = nextDeque.getFront();
            nextDeque.deleteFront();
            preDeque.insertLast(front);

        }else if(preDeque.count > nextDeque.count){
            int rear = preDeque.getRear();
            boolean b = preDeque.deleteLast();
            nextDeque.insertFront(rear);
        }
    }
    
    public void pushFront(int val) {
        boolean b = preDeque.insertFront(val);
        refresh();
    }
    
    public void pushMiddle(int val) {
        boolean b = preDeque.insertLast(val);
        refresh();
    }
    
    public void pushBack(int val) {
        boolean b = nextDeque.insertLast(val);
        refresh();
    }
    
    public int popFront() {
        if(nextDeque.isEmpty()){
            return -1;
        }
        int front = -1;
        if(preDeque.isEmpty()){
            front = nextDeque.getFront();
            nextDeque.deleteFront();
        }else {
            front = preDeque.getFront();
            boolean b = preDeque.deleteFront();
            refresh();
        }
        return front;
    }
    
    public int popMiddle() {
        if(nextDeque.isEmpty()){
            return -1;
        }
        int middle = -1;
        if(preDeque.count == nextDeque.count){
            middle = preDeque.getRear();
            preDeque.deleteLast();
        }else if(preDeque.count < nextDeque.count){
            middle = nextDeque.getFront();
            nextDeque.deleteFront();
        }
        refresh();
        return middle;
    }
    
    public int popBack() {
        if(nextDeque.isEmpty()){
            return -1;
        }
        int rear = nextDeque.getRear();
        nextDeque.deleteLast();
        refresh();
        return rear;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
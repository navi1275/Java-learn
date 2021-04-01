package leetcode.editor.cn;

//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 76 👎 0

public class LC641设计循环双端队列20210316{
    public static void main(String[] args) {

        MyCircularDeque circularDeque = new LC641设计循环双端队列20210316().new MyCircularDeque(4); // 设置容量大小为3
        circularDeque.insertLast(9);			        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        // circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(0);			        // 返回 true
        // circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getFront();				// 返回 4
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        int[] arr;
        int size=0;
        int count=0;
        int head=0;
        int tail=0;

        public void printArr(){
            if(isEmpty()){
                return;
            }
            int p = head;
            if(count == 1){
                System.out.println(arr[p]);
                return;
            }
            while (p != tail){
                System.out.print(arr[p] + ", ");
                p++;
                if(p == size){
                    p = 0;
                }
            }
            System.out.println();

        }

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            arr = new int[k];
            size = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            if(count > 0){
                head--;
                if(head < 0){
                    head = size - 1;
                }
            }
            arr[head] = value;
            count++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }
            if(count > 0){
                tail++;
                if(tail == size){
                    tail = 0;
                }
            }
            arr[tail] = value;
            count++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            arr[head] = 0;
            count--;
            if(count > 0){
                head++;
                if(head == size){
                    head = 0;
                }
            }
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            arr[tail]=0;
            count--;
            if(count > 0){
                tail--;
                if(tail < 0){
                    tail = size-1;
                }
            }
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return arr[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return arr[tail];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == count;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
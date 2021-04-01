package leetcode.editor.cn;
 
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1253 👎 0

import java.util.*;

/**
 * LC146LRU缓存机制
 * 2021-03-18 15:09:27
 */
public class LC146LRU缓存机制{
    public static void main(String[] args) {
         // Solution solution = new LC146LRU缓存机制().new Solution();

LRUCache lRUCache = new LC146LRU缓存机制().new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }



    }
class LRUCache1 {

        Map<Integer, ListNode> data;
        ListNode head;
        ListNode tail;
        int count;
        int size;

    public LRUCache1(int capacity) {
        data = new HashMap<>();
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
        size = capacity;
        count = 0;
    }

    private void insertHead(int key, ListNode node){
        if(head.next == node){
            return;
        }

        ListNode next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
        data.put(key, node);
        count++;
    }

    private void deleteNode(int key, ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        data.remove(key);
        count--;
    }
    
    public int get(int key) {
        ListNode node = getNode(key);
        if(node == null){
            return -1;
        }
        return node.val;
    }

    private ListNode getNode(int key){
        ListNode ret = data.get(key);
        if(ret == null){
            return null;
        }
        deleteNode(key, ret);
        insertHead(key, ret);
        return ret;
    }


    public void put(int key, int value) {
        ListNode node = getNode(key);
        if(node != null){
            node.val = value;
            return;
        }
        if(count == size){
            Set<Map.Entry<Integer, ListNode>> entries = data.entrySet();
            Iterator<Map.Entry<Integer, ListNode>> iterator = entries.iterator();
            Integer deleteKey = null;
            while (iterator.hasNext()){
                Map.Entry<Integer, ListNode> next = iterator.next();
                Integer key1 = next.getKey();
                ListNode value1 = next.getValue();
                if(value1 == tail.pre){
                    deleteKey = key1;
                }
            }
            deleteNode(deleteKey, tail.pre);

        }
        node = new ListNode(value);
        insertHead(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
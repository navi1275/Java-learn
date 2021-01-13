package com.navi.struct;

import java.util.HashMap;
import java.util.Objects;

/**
 * LRU (Least Recently Used) 的意思就是近期最少使用算法
 *
 * @author navi
 * @date 2019-04-09
 * @since 1.0.0
 */
public class LRUCache {

    //用hashmap存储值
    private HashMap<Integer, LinkedNode> data = new HashMap<>();
    //使用双向链表来存储节点实现最近使用
    //定义头尾节点
    private LinkedNode head;
    private LinkedNode tail;
    private int count;
    private int capacity;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;

        head = new LinkedNode();
        head.prev = null;
        tail = new LinkedNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public void put(int key, int val) {
        LinkedNode node = new LinkedNode();
        node.key = key;
        node.value = val;

        addNode(node);
    }

    public int get(int key) {

        int val = -1;
        LinkedNode node = data.get(key);
        if (node != null) {
            val = node.value;
            moveToHead(node);
        }

        return val;
    }

    /**
     * 添加节点
     * @param node
     */
    private void addNode(LinkedNode node) {
        int key = node.key;

        //包含当前节点，应该先删除
        if(data.containsKey(key)){
            deleteNode(node);
        }

        //容量满了，应该删除最后的节点
        if(count == capacity){
            deleteNode(tail.prev);
        }


        //插入节点
        LinkedNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;

        data.put(key, node);
        count++;
    }

    /**
     * 删除节点
     * @param node
     */
    private void deleteNode(LinkedNode node) {
        LinkedNode next = head.next;
        int key = node.key;
        while (next != null) {
            if(next.key == key){
                LinkedNode prev = next.prev;
                LinkedNode next1 = next.next;
                prev.next = next1;
                if(next1 != null){
                    next1.prev = prev;
                }
                data.remove(key);
                count--;
                break;
            }
            next = next.next;
        }
    }

    /**
     * 移动到头节点
     * @param node
     */
    private void moveToHead(LinkedNode node) {
        deleteNode(node);
        addNode(node);
    }


    private static class LinkedNode {
        public int key;
        public int value;
        public LinkedNode prev;
        public LinkedNode next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinkedNode that = (LinkedNode) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache.get(1) = " + cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println("cache.get(2) = " + cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println("cache.get(1) = " + cache.get(1));       // 返回 -1 (未找到)
        System.out.println("cache.get(3) = " + cache.get(3));      // 返回  3
        System.out.println("cache.get(4) = " + cache.get(4));       // 返回  4
    }
}

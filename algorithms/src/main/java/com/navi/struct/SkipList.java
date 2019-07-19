package com.navi.struct;

import com.sun.javafx.binding.IntegerConstant;
import lombok.Data;

/**
 * SkipList Class
 *
 * @author navi
 * @date 2019-05-21
 * @since 1.0.0
 */
@Data
public class SkipList {

    private static final int MAX_LEVEL = 16;

    private int size = 0;

    private int levelCount = 1;

    /**
     * 默认头节点
     */
    private Node head = new Node(Integer.MIN_VALUE, 16);

    /**
     * 插入节点
     * @param value
     */
    public void insert(int value){
        int level = getLevel();
        Node node = new Node(value, level);

        Node[] update = new Node[level];

        Node temp = head;
        for (int i = level - 1; i >= 0; i--){
            while (temp.next[i] != null && temp.next[i].value < value){
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        for (int i = 0; i < level; i++){
            node.next[i] = update[i].next[i];
            update[i].next[i] = node;
        }

        if(level > levelCount){
            levelCount = level;
        }
        size++;
        System.out.println("SKIPLIST 插入数据：" + value);
    }

    private void delete(int value){
        Node[] update = new Node[levelCount];

        Node temp = head;
        for (int i = levelCount - 1; i >= 0; i--){
            while (temp.next[i] != null && temp.next[i].value < value){
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        if(temp.next[0] != null && temp.next[0].value == value){
            for (int i = levelCount - 1; i >= 0; i--){
                if(update[i].next[i] != null && update[i].next[i].value == value){
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
            size--;
            System.out.println("SKIPLIST 删除数据：" + value);
        }
    }

    private Node find(int value){
        Node temp = head;
        while (temp.next[0] != null) {
            if(temp.next[0].value == value){
                return temp.next[0];
            }
            temp = temp.next[0];
        }
        return null;
    }

    /**
     * 打印所有节点
     *
     */
    public void print() {
        Node temp = head;
        System.out.println("SKIPLIST 数据：");
        while (temp.next[0] != null) {
            System.out.println(temp.next[0].value + "  ");
            temp = temp.next[0];
        }
    }

    /**
     * 随机获取级别
     * @return
     */
    private int getLevel(){
        int level = 1;
        for (;;){
            int num = (int)(Math.random() * 100);
            if(num % 2 == 0 && level < MAX_LEVEL){
                level++;
            }else {
                break;
            }

        }
        return level;
    }

    @Data
    class Node{
        private int value = -1;
        private int level = 0;
        private Node[] next;

        public Node(int value, int level) {
            this.value = value;
            this.level = level;
            this.next = new Node[level];
        }
    }

    //测试数据
    public static void main(String[] args) {
        SkipList list = new SkipList();
        for (int i = 0; i < 9; i+=2) {
            list.insert(i);
        }
        list.insert(3);
        list.insert(5);
        list.insert(7);
        list.insert(9);
        list.print();
        list.delete(3);
        list.print();
        System.out.println(list.find(3));
        System.out.println(list.size + " " + list.levelCount);
    }
}

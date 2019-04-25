package com.navi.concurrent;

/**
 * ArrayQueue Class
 *
 * 1.基本队列特性：先进先出。
 * 2.写入队列空间不可用时会阻塞。
 * 3.获取队列数据时当队列为空时将阻塞。
 *
 * @author navi
 * @date 2019-04-10
 * @since 1.0.0
 */
public class ArrayQueue<T> {

    /**
     * 队列数量
     */
    private int count;

    /**
     * 数据
     */
    private Object[] items;

    private Object full = new Object();

    private Object empty = new Object();

    private int pidx;

    private int gidx;

    public ArrayQueue(int size) {
        this.items = new Object[size];
    }

    public void put(T t){
        synchronized (full){
            while (count == items.length){
                try {
                    full.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        synchronized (empty){
            items[pidx] = t;
            count++;

            pidx++;
            if(pidx == items.length){
                pidx = 0;
            }

            empty.notify();
        }
    }

    public T get(){
        synchronized (empty){
            while (count == 0){
                try {
                    empty.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        synchronized (full){
            Object t = items[gidx];
            items[gidx] = null;
            count--;

            gidx++;
            if(gidx == items.length){
                gidx = 0;
            }

            full.notify();

            return (T)t;
        }
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int size() {
        return count;
    }
}

package com.sanshao90.mycollection.queue;

/**
 * @Project : mycollection
 * @Description : 顺序循环队列
 * @Author : sanshao90
 * @Date : 2018/3/2
 */
public class MySeqCycleQueue<E> implements MyQueue<E> {

    private Object[] value;// 存储队列数组元素
    private int front;// 队头下标
    private int rear;// 队尾下标

    public MySeqCycleQueue(int capacity) {
        value = new Object[Math.abs(capacity)];
        this.front = this.rear = 0;
    }

    public MySeqCycleQueue() {
        this(16);
    }

    /**
     * 判断队列是否为空，若为空返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 元素入队，操作成功返回true
     *
     * @param element
     * @return
     */
    @Override
    public boolean enqueue(E element) {
        if (element == null) {
            return false;
        }
        if (this.front == (this.rear + 1) % this.value.length) {
            Object[] temp = this.value;
            this.value = new Object[temp.length * 2];// 扩充数组容量为2倍
            int i = this.front;
            int j = 0;
            while (i != this.rear) {
                this.value[j] = temp[i];
                i = (i + 1) % temp.length;
                j++;
            }
            this.front = 0;
            this.rear = j;
        }
        this.value[this.rear] = element;
        this.rear = (this.rear + 1) % this.value.length;
        return true;
    }

    /**
     * 出队，返回当前队头元素，若队列为空则返回null
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (!isEmpty()) {
            E temp = (E) this.value[this.front];// 取队头元素
            this.front = (this.front + 1) % this.value.length;// front 下标变化规律
            return temp;
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MySeqCycleQueue{");
        if (!isEmpty()) {
            for (int i = this.front, n = this.rear - 1; i <= n; i++) {
                if (i == n) {
                    sb.append(this.value[i]);
                } else {
                    sb.append(this.value[i]).append(",");
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

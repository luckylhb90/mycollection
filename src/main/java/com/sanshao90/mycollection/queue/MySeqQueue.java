package com.sanshao90.mycollection.queue;

/**
 * @Project : mycollection
 * @Description : 顺序队列
 * @Author : sanshao90
 * @Date : 2018/3/1
 */
public class MySeqQueue<E> implements MyQueue<E> {

    private Object[] value;// 存储队列数据元素的数组
    private int front;// 对头下标
    private int rear;// 队尾下标


    public MySeqQueue(int capacity) {
        value = new Object[Math.abs(capacity)];
        this.front = -1;
        this.rear = -1;
    }

    public MySeqQueue() {
        this(16);
    }

    /**
     * 判断队列是否为空，若为空返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
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
        if (isEmpty()) {
            this.value[0] = element;
            this.front++;
            this.rear++;
        } else { // 非空队列，入队更改队尾结点指向
            if (this.rear == this.value.length - 1) {// 队列已满
                Object[] temp = this.value;
                this.value = new Object[this.value.length * 2];//扩容当前队列2倍
                for (int i = 0, n = temp.length; i < n; i++) {
                    this.value[i] = temp[i];
                }
            }
            this.value[++this.rear] = element;
        }
        return true;
    }

    /**
     * 出队，返回当前队头元素，若队列为空则返回null
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E temp = (E) this.value[this.front];
        this.front++;
        return temp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MySeqQueue{");
        if (!isEmpty()) {
            for (int i = this.front; i <= this.rear; i ++) {
                if (i == this.rear) {
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

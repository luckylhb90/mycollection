package com.sanshao90.mycollection.queue;

import com.sanshao90.mycollection.node.Node;

/**
 * @Project : mycollection
 * @Description : 链式队列
 * @Author : sanshao90
 * @Date : 2018/3/2
 */
public class MyLinkedQueue<E> implements MyQueue<E> {

    private Node<E> front; // 队列头结点
    private Node<E> rear; // 队列尾结点

    public MyLinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * 判断队列是否为空，若为空返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.front == null && this.rear == null;
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
        Node<E> q = new Node<>(element);
        if (!isEmpty()) {
            this.rear.next = q;
        } else {
            this.front = q;
        }
        this.rear = q;
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
            E temp = this.front.data;
            this.front = this.front.next;
            if (this.front == null) {
                this.rear = null;
            }
            return temp;
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyLinkedQueue{");
        Node<E> p = this.front;
        while (p != null) {
            if (p == this.rear) {
                sb.append(p.data);
            } else {
                sb.append(p.data).append(",");
            }
            p = p.next;
        }
        sb.append('}');
        return sb.toString();
    }
}

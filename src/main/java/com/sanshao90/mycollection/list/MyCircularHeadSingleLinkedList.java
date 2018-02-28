package com.sanshao90.mycollection.list;

/**
 * @Project : mycollection
 * @Description : 循环单链表类
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MyCircularHeadSingleLinkedList<E> extends MyHeadSingleLinkedList<E> {

    public MyCircularHeadSingleLinkedList() {
        super();
        this.head.next = this.head;
    }

    /**
     * 插入element对象
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        if (element == null) {
            return false;
        }
        this.rear.next = new Node<>(element);
        this.rear = this.rear.next;
        this.rear.next = this.head;
        this.length++;
        return true;
    }

    /**
     * 移除序号为index的对象，返回被移除对象
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        E old = null;
        if (index >= 0) {
            Node<E> p = this.head;
            int i = 0;
            while (p.next != null && i < index) {
                i++;
                p = p.next;
            }
            if (p.next != null) {
                old = p.next.data;
                if (p.next == this.rear) {
                    this.rear = p;
                    this.rear.next = this.head;
                }
                p.next = p.next.next;
                this.length--;
            }
        }
        return old;
    }

    /**
     * 清空带头结点的单链表
     */
    @Override
    public void clear() {
        this.head.next = this.head;
        this.length = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        Node<E> p = this.head.next;
        while (p.data != null) {
            str.append(p.data.toString());
            p = p.next;
            if (p != null) {
                str.append(", ");
            }
        }
        return str.append(")").toString();
    }
}

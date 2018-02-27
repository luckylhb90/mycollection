package com.sanshao90.mycollection;

/**
 * @Project : mycollection
 * @Description : 双向链表类
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MyDoubleLinkedList<E> implements MyList<E> {

    protected DoubleNode<E> head;//双链表头结点
    protected int length;//双链表长度

    public MyDoubleLinkedList() {
        this.head = new DoubleNode<>(null, null, null);
        this.length = 0;
    }

    /**
     * 判断线性表是否为空，若为空则返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    /**
     * 返回线性表长度
     *
     * @return
     */
    @Override
    public int length() {
        return length;
    }

    /**
     * 返回序号为index的对象，index初始值为0
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        DoubleNode<E> p = this.head;
        int i = 0;
        while (p != null && i < index) {
            i++;
            p = p.next;
        }
        if (p != null) {
            return p.data;
        }
        return null;
    }

    /**
     * 设置序号为index，对象为element, 返回原对象
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        if (index <= this.length && element != null) {
            DoubleNode<E> p = this.head;
            int i = 0;
            while (p != null && i < index) {
                i++;
                p = p.next;
            }
            if (p != null) {
                E old = p.data;
                p.data = element;
                return old;
            }
        }
        return null;
    }

    /**
     * 插入element对象，插入后对象序号为index
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || element == null) {
            return false;
        }
        if (index > this.length) {//尾插入，把元素插入到最后面
            return this.add(element);
        } else {
            DoubleNode<E> p = this.head;// p 指向头结点
            int i = 0;
            while (p != null && i < index) {
                i++;
                p = p.next;
            }
            if (p != null) {
                DoubleNode<E> q = new DoubleNode<>(element);
                q.prev = p.prev;
                q.next = p;
                p.prev.next = q;
                p.prev = q;
                this.length++;
                return true;
            }
        }
        return false;
    }

    /**
     * 双链表最后插入元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        if (element == null) {
            return false;
        }
        DoubleNode<E> p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        DoubleNode<E> q = new DoubleNode<>(element);
        p.next = q;
        q.prev = p;
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
            if (index == 0) {
                index = 1;
            }
            DoubleNode<E> p = this.head;
            int i = 0;
            while (p != null & i < index) {
                i++;
                p = p.next;
            }
            if (p != null) {
                old = p.data;
                p.prev.next = p.next;
                if (p.next != null) {
                    p.next.prev = p.prev;
                }
                this.length--;
            }
        }
        return old;
    }

    /**
     * 清空线性表
     */
    @Override
    public void clear() {
        this.head.next = null;
        this.length = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        DoubleNode<E> p = this.head.next;
        while (p != null) {
            str.append(p.data.toString());
            p = p.next;
            if (p != null) {
                str.append(", ");
            }
        }
        return str.append(")").toString();
    }
}

package com.sanshao90.mycollection;

/**
 * @Project : mycollection
 * @Description : 带头结点的单链表类
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MyHeadSingleLinkedList<E> extends MySingleLinkedList<E> implements MyList<E> {

//    protected Node<E> head;// 单链表的头结点
    protected Node<E> rear;// 单链表的尾结点
    protected int length; // 单链表的长度

    public MyHeadSingleLinkedList() {
        this.head = new Node<E>(null); // 构造头结点，元素值为null
        this.rear = this.head;// 构造尾结点，初始化时，头尾都指向头结点
        this.length = 0;//初始化链表长度
    }

    /**
     * 判断带头结点的单链表是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    /**
     * 返回带头结点的单链表的长度，时间复杂度为O(1)
     *
     * @return
     */
    @Override
    public int length() {
        return this.length;
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
        if (element == null) {
            return false;
        }
        if (index >= this.length) {
            return this.add(element);
        } else {
            Node<E> p = this.head;
            int i = 0;
            while (p.next != null && i < index) {
                i++;
                p = p.next;
            }
            Node<E> q = new Node<>(element);
            q.next = p.next;
            p.next = q;
            this.length++;
            return true;
        }
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
        this.head.next = null;
        this.rear = this.head;
        this.length = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        Node<E> p = this.head.next;
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

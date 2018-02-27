package com.sanshao90.mycollection;

/**
 * @Project : mycollection
 * @Description :  单链表类，实现线性表接口
 * @Author : sanshao90
 * @Date : 2018/2/26
 */
public class MySingleLinkedList<E> implements MyList<E> {

    //单链表头节点，指向单链表第一个结点
    protected Node<E> head;

    /**
     * 构造空的单链表
     */
    public MySingleLinkedList() {
        this.head = null;
    }

    /**
     * 构造指定头结点的单链表
     *
     * @param head
     */
    public MySingleLinkedList(Node<E> head) {
        this.head = head;
    }

    /**
     * 判断单链表是否为空，若为空则返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * 遍历返回单链表长度
     *
     * @return
     */
    @Override
    public int length() {
        Node<E> p = this.head;//获取头结点
        int i = 0;
        while (p != null) {//判断链表是否结束
            i++;
            p = p.next;//p到达后继节点
        }
        return i;
    }

    /**
     * 返回序号为index的对象，index初始值为0
     * 如果链表为空或index错误则返回null
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        Node<E> p = this.head;
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
     * 操作成功返回原对象，失败返回null
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        if (this.head != null && index >= 0 && element != null) {
            Node<E> p = this.head;
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
        if (element == null) {
            return false;
        }
        Node<E> q = new Node<>(element);//创建待插入结点
        Node<E> p = this.head;
        if (p == null || index <= 0) {//插入头结点
            q.next = p;
            this.head = q;
        } else {
            int i = 0;
            while (p.next != null && i < index - 1) {
                i++;
                p = p.next;
            }
            q.next = p.next;
            p.next = q;
        }
        return true;
    }

    /**
     * 插入element对象
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        return add(Integer.MAX_VALUE, element);
    }

    /**
     * 移除序号为index的对象，返回被移除对象
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        Node<E> p = this.head;
        if (index < 0 || p == null) {
            return null;
        }
        E old = null;
        if (index == 0) {
            old = p.data;
            this.head = p.next;
            return old;
        } else {
            int i = 0;
            while (p != null && i < index - 1) {// 定位到删除结点的前驱结点
                i++;
                p = p.next;
            }
            if (p != null && p.next != null) {
                old = p.next.data;
                p.next = (p.next).next;//删除p的后继结点
            }
        }
        return old;
    }

    /**
     * 清空单链表
     */
    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        Node<E> p = this.head;
        while (p != null) {
            str.append(p.data.toString());
            p = p.next;
            if (p != null) {
                str.append(", ");
            }
        }
        return str.append(")").toString();
    }


    /**
     * 链表节点类
     *
     * @param <E>
     */
    private static class Node<E> {
        //链接数据域，保存数据元素
        public E       data;
        //链表地址域，引用后继节点
        public Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }
    }
}

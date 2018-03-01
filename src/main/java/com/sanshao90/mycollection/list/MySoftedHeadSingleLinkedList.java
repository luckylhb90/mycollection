package com.sanshao90.mycollection.list;

import com.sanshao90.mycollection.node.Node;

/**
 * @Project : mycollection
 * @Description : 可排序的单链表 可参考 TreeSet
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MySoftedHeadSingleLinkedList<E> extends MyHeadSingleLinkedList<E> {

    public MySoftedHeadSingleLinkedList() {
        super();
    }

    /**
     * 根据指定对象的大小把对象插入到合适的位置上，操作成功返回true;
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        if (element == null || !(element instanceof Comparable)) {
            return false;
        }
        Comparable<E> cmp = (Comparable<E>) element;
        Node<E> front = this.head;
        Node<E> p = front.next;// front 是 p 的前驱结点
        while (p != null && (cmp.compareTo(p.data)) > 0) {
            front = p;
            p = p.next;
        }
        front.next = new Node<E>(element, p);
        if (p == null) {
            this.rear = front.next;
        }
        this.length++;
        return true;
    }

    /**
     * 移除指定元素，操作成功返回true
     *
     * @param element
     * @return
     */
    public boolean remove(E element) {
        if (element == null || !(element instanceof Comparable)) {
            return false;
        }
        Comparable<E> cmp = (Comparable<E>) element;
        Node<E> front = this.head;
        Node<E> p = front.next;
        while (p != null && (cmp.compareTo(p.data) > 0)) {
            front = p;
            p = p.next;
        }
        if (p == null || cmp.compareTo(p.data) == 0) {
            return false;
        }

        front.next = p.next;
        if (p == this.rear) {
            this.rear = front;
        }
        this.length--;
        return true;
    }
}

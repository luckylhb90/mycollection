package com.sanshao90.mycollection;

/**
 * 链表节点类
 *
 * @param <E>
 */
public class Node<E> {
    //链接数据域，保存数据元素
    public E data;
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
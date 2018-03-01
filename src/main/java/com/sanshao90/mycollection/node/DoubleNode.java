package com.sanshao90.mycollection.node;

/**
 * @Project : mycollection
 * @Description : 双链表结点类
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class DoubleNode<E> {

    public E data;//数据元素
    public DoubleNode<E> prev;//前驱结点
    public DoubleNode<E> next;//后继结点

    public DoubleNode(E data, DoubleNode<E> prev, DoubleNode<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(E data) {
        this(data, null, null);
    }

    public DoubleNode() {
    }
}

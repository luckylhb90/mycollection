package com.sanshao90.mycollection.list;

import com.sanshao90.mycollection.node.Node;

/**
 * @Project : mycollection
 * @Description :  可逆转的单链表
 * @Author : sanshao90
 * @Date : 2018/2/26
 */
public class MyReverseSingleLinkedList<E> extends MySingleLinkedList<E> {

    /**
     * 构造空的单链表
     */
    public MyReverseSingleLinkedList() {
        super();
    }

    /**
     * 单链表逆转
     */
    public void reverse() {
        Node<E> p = this.head;
        Node<E> front = null;
        Node<E> q = null;

        while (p != null) {
            q = p.next;// 设置q结点是p的后继结点
            p.next = front;// 使p的后继结点指向其前驱节点
            front = p;// front结点向后移动
            p = q;// p结点向后移动
        }
        this.head = front; // 头结点指向front
    }
}

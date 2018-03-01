package com.sanshao90.mycollection.stack;

import com.sanshao90.mycollection.node.Node;

/**
 * @Project : mycollection
 * @Description : 链式栈
 * @Author : sanshao90
 * @Date : 2018/3/1
 */
public class MyLinkedStack<E> implements MyStack<E> {

    private Node<E> top;//栈顶元素结点

    public MyLinkedStack() {
        this.top = null;
    }

    /**
     * 判断栈是否为空, 若为空在返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    /**
     * element元素入栈，若操作成功返回true
     *
     * @param element
     * @return
     */
    @Override
    public boolean push(E element) {
        if (element == null) {
            return false;
        }
        this.top = new Node<E>(element, this.top);
        return true;
    }

    /**
     * 出栈， 返回当前栈顶元素，若栈为空返回Null
     *
     * @return
     */
    @Override
    public E pop() {
        if (!isEmpty()) {
            E temp = this.top.data;// 获取栈顶元素
            this.top = this.top.next;// 删除原来的栈顶元素，改变栈顶元素
            return temp; // 返回原来的栈顶元素
        }
        return null;
    }

    /**
     * 取栈顶元素值，未出栈，若栈为空返回Null
     *
     * @return
     */
    @Override
    public E get() {
        if (!isEmpty()) {
            return this.top.data;
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyLinkedStack{");
        Node<E> p = this.top;
        while (p != null) {
            if (p.next == null) {
                sb.append(p.data);
            } else {
                sb.append(p.data).append(",");
            }
            p = p.next;
        }
        sb.append("top=").append(top);
        sb.append('}');
        return sb.toString();
    }
}

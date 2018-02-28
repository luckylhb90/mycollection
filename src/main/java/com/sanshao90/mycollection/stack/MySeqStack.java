package com.sanshao90.mycollection.stack;

/**
 * @Project : mycollection
 * @Description : 顺序栈实现
 * @Author : sanshao90
 * @Date : 2018/2/28
 */
public class MySeqStack<E> implements MyStack<E> {

    private Object[] value;// 存储栈的数据元素

    private int top;//栈顶元素下标

    public MySeqStack() {
        this(16);//初始化栈容量
    }

    public MySeqStack(int capacity) {
        this.value = new Object[Math.abs(capacity)];
        this.top = -1;//栈顶下标初始化为-1
    }

    /**
     * 判断栈是否为空, 若为空在返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
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
        if (this.top == value.length - 1) {//栈满，扩容
            Object[] temp = this.value;
            this.value = new Object[temp.length * 2];//扩为原数组的2倍
            for (int i = 0, n = temp.length; i < n; i++) {//复制原数组到新数组
                this.value[i] = temp[i];
            }
        }
        this.top++;//栈顶+1
        this.value[top] = element;// 入栈元素到栈顶
        return true;
    }

    /**
     * 出栈， 返回当前栈顶元素，若栈为空返回Null
     *
     * @return
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.value[top--];
    }

    /**
     * 取栈顶元素值，未出栈，若栈为空返回Null
     *
     * @return
     */
    @Override
    public E get() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.value[top];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MySeqStack{");
        for(int i = top; i >=0 ; i--) {
            if(this.value[i] != null) {
                if(i == 0) {
                    sb.append(this.value[i]);
                } else {
                    sb.append(this.value[i]).append(",");
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

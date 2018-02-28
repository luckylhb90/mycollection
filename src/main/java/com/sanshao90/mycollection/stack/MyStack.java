package com.sanshao90.mycollection.stack;

/**
 * @Project : mycollection
 * @Description : 栈接口
 * @Author : sanshao90
 * @Date : 2018/2/28
 */
public interface MyStack<E> {

    /**
     * 判断栈是否为空, 若为空在返回true
     * @return
     */
    boolean isEmpty();

    /**
     * element元素入栈，若操作成功返回true
     * @param element
     * @return
     */
    boolean push(E element);


    /**
     * 出栈， 返回当前栈顶元素，若栈为空返回Null
     * @return
     */
    E pop();

    /**
     * 取栈顶元素值，未出栈，若栈为空返回Null
     * @return
     */
    E get();
}

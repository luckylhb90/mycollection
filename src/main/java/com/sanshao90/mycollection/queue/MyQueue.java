package com.sanshao90.mycollection.queue;

/**
 * @Project : mycollection
 * @Description : 队列接口
 * @Author : sanshao90
 * @Date : 2018/3/1
 */
public interface MyQueue<E> {

    /**
     * 判断队列是否为空，若为空返回true
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 元素入队，操作成功返回true
     *
     * @param element
     * @return
     */
    boolean enqueue(E element);

    /**
     * 出队，返回当前队头元素，若队列为空则返回null
     *
     * @return
     */
    E dequeue();
}

package com.sanshao90.mycollection.queue;

import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/3/2
 */
public class MyLinkedQueueTest {

    @Test
    public void test() {
        MyQueue<String> queue = new MyLinkedQueue<>();
        queue.dequeue();
        System.out.println(queue.toString());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }
}

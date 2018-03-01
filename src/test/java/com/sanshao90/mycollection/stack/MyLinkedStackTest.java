package com.sanshao90.mycollection.stack;

import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/3/1
 */
public class MyLinkedStackTest {

    @Test
    public void test() {
        MyStack<String> stack = new MyLinkedStack<>();
        System.out.println(stack.isEmpty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.toString());
        stack.pop();
        stack.push("D");
        stack.get();
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());

    }
}

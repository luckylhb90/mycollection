package com.sanshao90.mycollection.stack;

import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/28
 */
public class MySeqStackTest {

    @Test
    public void test() {
        MyStack<String> stack = new MySeqStack<>();
        System.out.println(stack.isEmpty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.toString());
        stack.pop();
        stack.push("E");
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
    }
}

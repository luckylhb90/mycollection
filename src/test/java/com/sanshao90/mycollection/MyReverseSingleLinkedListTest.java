package com.sanshao90.mycollection;

import org.junit.Test;

public class MyReverseSingleLinkedListTest {

    @Test
    public void test_reverse() {
        MyReverseSingleLinkedList<Integer> linkedList = new MyReverseSingleLinkedList<>();
        for (int i = 1; i < 11; i++) {
            linkedList.add(i);
        }
        System.out.println("单链表：" + linkedList.toString());
        linkedList.reverse();
        System.out.println("反转单链表：" + linkedList.toString());
    }
}

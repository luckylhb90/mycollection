package com.sanshao90.mycollection;

import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/28
 */
public class MyDoubleLinkedListTest {

    @Test
    public void test_() {
        MyList<String> lists = new MyDoubleLinkedList<>();
        lists.add("A");
        lists.add("B");
        System.out.println(lists.toString());
        lists.remove(2);
        System.out.println(lists.toString());
        lists.add(5, "C");
        lists.add(6, "D");
        System.out.println(lists.toString());
    }
}

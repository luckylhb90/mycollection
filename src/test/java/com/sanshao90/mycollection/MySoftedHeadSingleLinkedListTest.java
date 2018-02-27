package com.sanshao90.mycollection;

import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MySoftedHeadSingleLinkedListTest {

    @Test
    public void test_all() {
        MySoftedHeadSingleLinkedList<Integer> lists = new MySoftedHeadSingleLinkedList<>();
        int n = 10;
        System.out.println("insert....");
        for (int i = 0; i < n; i ++) {
            int k = (int) (Math.random() * 100);
            lists.add(k);
            System.out.print(k +"   ");
        }
        System.out.println();
        System.out.println(lists.toString());
    }
}

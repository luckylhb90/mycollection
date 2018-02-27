package com.sanshao90.mycollection;

import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MyHeadSingleLinkedListTest {


    @Test
    public void test_add() {
        MyList<String> lists = new MyHeadSingleLinkedList<>();

        for(int i = 1; i < 11; i++) {
            lists.add(0, new String((char)('A'+i)+""));
        }

        System.out.println(lists.toString());

        lists.remove(0);

        System.out.println(lists.toString());
    }
}

package com.sanshao90.mycollection.list;

import com.sanshao90.mycollection.list.MyCircularHeadSingleLinkedList;
import com.sanshao90.mycollection.list.MyList;
import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MyCircularHeadSingleLinkedListTest {

    @Test
    public void test_() {
        MyList<String> lists = new MyCircularHeadSingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(0, new String((char) ('A' + i) + ""));
        }
        System.out.println(lists.toString());
        System.out.println(lists.get(1));
        lists.remove(0);
        System.out.println(lists.toString());
    }
}

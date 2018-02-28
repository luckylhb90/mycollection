package com.sanshao90.mycollection.list;

import com.sanshao90.mycollection.list.MyList;
import com.sanshao90.mycollection.list.MySingleLinkedList;
import org.junit.Test;

public class MySingleLinkedListTest {

    @Test
    public void test_all() {
        MyList<String> linkeds = new MySingleLinkedList<>();

        linkeds.add("A");
        linkeds.add("B");
        linkeds.add("C");
        System.out.printf("元素个数是:%s %n", linkeds.length());

        System.out.println(linkeds.toString());
    }
}

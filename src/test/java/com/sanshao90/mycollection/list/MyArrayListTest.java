package com.sanshao90.mycollection.list;

import com.sanshao90.mycollection.list.MyArrayList;
import com.sanshao90.mycollection.list.MyList;
import org.junit.Test;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/27
 */
public class MyArrayListTest {

    @Test
    public void test_All() {
        MyList<String> lists = new MyArrayList<String>();

        lists.add("A");
        lists.add("B");
        lists.add("C");

        System.out.printf("lists线性表元素个数：%s %n", lists.length());

        MyList<String> listss = new MyArrayList<String>(10);

        listss.add("D");
        listss.add("E");
        listss.add("F");
        listss.add("G");

        System.out.printf("listss线性表元素个数：%s %n", listss.length());


    }
}

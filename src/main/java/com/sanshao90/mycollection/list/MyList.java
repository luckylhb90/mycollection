package com.sanshao90.mycollection.list;

/**
 * @Project : mycollection
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/26
 */
public interface MyList<E> {

    /**
     * 判断线性表是否为空，若为空则返回true
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回线性表长度
     *
     * @return
     */
    int length();

    /**
     * 返回序号为index的对象，index初始值为0
     *
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置序号为index，对象为element, 返回原对象
     *
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 插入element对象，插入后对象序号为index
     *
     * @param index
     * @param element
     * @return
     */
    boolean add(int index, E element);

    /**
     * 插入element对象
     *
     * @param element
     * @return
     */
    boolean add(E element);

    /**
     * 移除序号为index的对象，返回被移除对象
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 清空线性表
     */
    void clear();

}

package com.sanshao90.mycollection.list;

import com.google.common.base.MoreObjects;

/**
 * @Project : mycollection
 * @Description : 顺序表类，实现线性表接口
 * @Author : sanshao90
 * @Date : 2018/2/26
 */
public class MyArrayList<E> implements MyList<E> {

    //对象数组
    private Object[] table;

    //顺序表长度
    private int length;

    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int capacity) {
        this.table = new Object[Math.abs(capacity)];
        this.length = 0;
    }


    /**
     * 判断线性表是否为空，若为空则返回true
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * 返回线性表长度
     *
     * @return
     */
    @Override
    public int length() {
        return this.length;
    }

    /**
     * 返回序号为index的对象，index初始值为0
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return index >= 0 && index < this.length ? (E) this.table[index] : null;
    }

    /**
     * 设置序号为index，对象为element, 返回原对象
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        if (index >= 0 && index < this.length && element != null) {
            E old = (E) this.table[index];
            this.table[index] = element;
            return old;
        }
        return null;
    }

    /**
     * 插入element对象，插入后对象序号为index
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean add(int index, E element) {
        if (element == null) {
            return false;
        }
        if (this.length == this.table.length) {//数组已满，需要扩容数组
            Object[] temp = this.table;
            this.table = new Object[temp.length * 2];//重新申请容量更大的数组
            for (int i = 0, n = temp.length; i < n; i++) {
                this.table[i] = temp[i];//复制数组元素 ， O(n)
            }
        }

        if (index < 0) {
            index = 0; // 下标容错
        }

        if (index > this.length) {
            index = this.length; // 下标容错
        }

        for (int j = this.length - 1; j >= index; j--) {// 元素后移， 平均移动n/2
            this.table[j + 1] = this.table[j];
        }

        this.table[index] = element;
        this.length++;
        return true;
    }

    /**
     * 插入element对象
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        return this.add(this.length, element);
    }

    /**
     * 移除序号为index的对象，返回被移除对象
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        if (this.length != 0 && index >= 0 && index < this.length) {
            E old = (E) this.table[index];
            for (int i = index, n = this.length - 1; i < n; i++) {//元素前移，平均移动n/2
                this.table[i] = this.table[i + 1];
            }
            this.table[this.length - 1] = null;
            this.length--;
            return old;
        }
        return null;
    }

    /**
     * 清空线性表
     */
    @Override
    public void clear() {
        if (this.length != 0) {
            for (int i = 0, n = this.length; i < n; i++) {
                this.table[i] = null;
            }
            this.length = 0;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("table", table)
                .add("length", length)
                .toString();
    }
}

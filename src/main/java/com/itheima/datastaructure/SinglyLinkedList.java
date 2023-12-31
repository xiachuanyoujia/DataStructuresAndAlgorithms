package com.itheima.datastaructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> { //整体
    private Node head = null;  //头指针

    /**
     * 迭代器实现遍历
     *
     * @return
     */
    public Iterator<Integer> iterator() {
        //匿名内部类 -> 带名字的内部类
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

        @Override
        public boolean hasNext() {  //是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { //返回当前值，并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        int value;  //值
        Node next;  //下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     * arams: value -待添加值
     *
     * @param value
     */
    public void addFirst(int value) {
        //1.链表为空
        //head = new Node(value, null);
        //2.链表非空
        head = new Node(value, head);
    }

    /**
     * 遍历链表1
     * Params: consumer -要执行的操作
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    @Test
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

//        list.loop1(val -> {
        list.loop2(val -> {
            System.out.println(val);
        });
    }

    /**
     * 遍历链表2
     * Params: consumer -要执行的操作
     *
     * @param consumer
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Test
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer value : list) {
            System.out.println(value);
        }
    }

    private Node findLast() {
        if (head == null) { //空链表
            return null;
        }

        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    /**
     * 向链表尾部添加
     * Params: value-待添加值
     *
     * @param value
     */
    public void addList(int value) {
        Node last = findLast();

        if (last == null) {
            addFirst(value);
            return;
        }

        last.next = new Node(value, null);
    }

    @Test
    public void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addList(1);
        list.addList(2);
        list.addList(3);
        list.addList(4);

        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    /**
     * 根据索引查找
     * Params: index-索引
     * Returns:找到,返回该索引位置节点的值
     * Throws: IllegalArgumentException-找不到,抛出index非法异常
     *
     * @param index
     * @return
     */
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;    //没找到
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    @Test
    public void test4() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addList(1);
        list.addList(2);
        list.addList(3);    //2
        list.addList(4);

//        int i = list.get(2);
        int i = list.get(10);
        System.out.println(i);
    }

    /**
     * 向索引位置插入
     * Params: index-索引
     * value-待插入值
     * Throws: IllegalArgumentException-找不到,抛出index非法异常
     */
    public void insert(int index, int value) throws IllegalArgumentException {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);    //找到上一个节点
        if (prev == null) { //找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    @Test
    public void test5() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addList(1);
        list.addList(2);
        list.addList(3);
        list.addList(4);

        list.insert(0, 5);
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    /**
     * 删除第一个
     * Throws: 1llegalArgumentException--如果不存在,抛出index非法异常
     */
    public void removeFirst() {
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    @Test
    public void test6() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addList(1);
        list.addList(2);
        list.addList(3);
        list.addList(4);

        list.removeFirst();
        for (Integer val : list) {
            System.out.println(val);
        }
        System.out.println("==============");
        list.removeFirst();
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    /**
     * 从索引位置删除
     * Params: index-索引
     * Throws: IllegalArgumentException -找不到,抛出index非法异常
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

    @Test
    public void test7() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addList(1);
        list.addList(2);
        list.addList(3);
        list.addList(4);

//        list.remove(2);
//        list.remove(0);
//        list.remove(5);
        list.remove(4);

        for (Integer val : list) {
            System.out.println(val);
        }
    }
}

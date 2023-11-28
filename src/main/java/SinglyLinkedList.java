import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.traversal.NodeIterator;

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
}

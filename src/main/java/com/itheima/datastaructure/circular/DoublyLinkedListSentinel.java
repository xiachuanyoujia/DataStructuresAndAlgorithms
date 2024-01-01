package com.itheima.datastaructure.circular;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    //添加到第一个
    //arams: value -待添加值
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    @Test
    public void testAddFirst() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        assertIterableEquals(List.of(5, 4, 3, 2, 1), list);
    }

    //添加到最后一个
    //Params: value-待添加值
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    @Test
    public void testAddLast() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);
    }

    //删除第一个
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    @Test
    public void testRemoveFirst() {
        DoublyLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(5), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    //删除最后一个
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }
    @Test
    public void testRemoveLast() {
        DoublyLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1,2, 3, 4), list);
        list.removeLast();
        assertIterableEquals(List.of(1,2, 3), list);
        list.removeLast();
        assertIterableEquals(List.of(1,2), list);
        list.removeLast();
        assertIterableEquals(List.of(1), list);
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    //根据值删除
    //Params: value -目标值
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    @Test
    public void testRemoveByValue() {
        DoublyLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeByValue(2);
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeByValue(3);
        assertIterableEquals(List.of(4, 5), list);
        list.removeByValue(4);
        assertIterableEquals(List.of(5), list);
        list.removeByValue(5);
        assertIterableEquals(List.of(), list);
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private DoublyLinkedListSentinel getList() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }

}

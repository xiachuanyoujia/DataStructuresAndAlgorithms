package com.itheima.datastaructure.circular;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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



}

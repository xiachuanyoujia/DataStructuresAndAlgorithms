package com.itheima.datastaructure.queue;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueue1Test {
    @Test
    public void testOffer() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        assertTrue(queue.offer(3));
        assertTrue(queue.offer(4));
        assertTrue(queue.offer(5));
        assertFalse(queue.offer(6));
    }
    @Test
    public void testPoll() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(1);
        queue.offer(1);
        assertEquals(1, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeek() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void testIsEmpty() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        assertTrue(queue.isEmpty());

        queue.offer(1);
        assertFalse(queue.isEmpty());

        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        assertFalse(queue.isfull());

        queue.offer(1);
        assertFalse(queue.isfull());

        queue.offer(2);
        assertFalse(queue.isfull());
    }

    @Test
    public void testIterator() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}

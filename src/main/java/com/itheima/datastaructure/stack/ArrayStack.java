package com.itheima.datastaructure.stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {

    private E[] array;
    private int top;    //栈顶指针

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isEmpty()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isFull()) {
            return null;
        }
        return array[--top];
    }

    @Override
    public E peek() {
        if (isFull()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}

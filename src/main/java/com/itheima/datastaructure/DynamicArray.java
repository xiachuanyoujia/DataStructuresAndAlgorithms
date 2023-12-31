package com.itheima.datastaructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array = {};

    /**
     * 向最后位置[size]添加元素
     * Params: element-待添加元素
     *
     * @param element
     */
    public void addList(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    /**
     * 向[0 .. size]位置添加元素
     * arams: index-索引位置
     * element-待添加元素
     *
     * @param index
     * @param element
     * @throws IllegalArgumentException
     */
    public void add(int index, int element) throws IllegalArgumentException {
        checkAndGrow();

        if (index > size) throw new IllegalArgumentException("index>size越界");

        //添加逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        //容量检查
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            //进行扩容，1.5
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * 从[0 .. size)范围删除元素
     * Params: index-索引位置
     * Return: 被删除的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    /**
     * 查询元素
     * Params: index-索引位置,在[O..size)区间内
     * Returns:该索引位置的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * 遍历方法1
     * arams: consumer一遍历要执行的操作，入参:每个元素
     *
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方法2–迭代器遍历
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {  //有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { //返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }


    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);
//        dynamicArray.addList(5);

        dynamicArray.add(2, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);

        dynamicArray.foreach((element) -> {
            System.out.println(element);
        });
    }

    @Test
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);

        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);

        dynamicArray.stream().forEach(element -> {
            System.out.println(element);
        });
    }

    @Test
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);
        dynamicArray.addList(5);

        int removed = dynamicArray.remove(2);
        assertEquals(3, removed);
        assertIterableEquals(List.of(1, 2, 4, 5), dynamicArray);
    }

    @Test
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addList(i + 1);
        }
        assertIterableEquals(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                dynamicArray
        );
    }
}

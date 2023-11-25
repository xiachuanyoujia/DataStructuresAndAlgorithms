import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array = new int[capacity];

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
        if (index > size) throw new IllegalArgumentException("index>size越界");

        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
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

        dynamicArray.stream().forEach(element->{
            System.out.println(element);
        });
    }
}

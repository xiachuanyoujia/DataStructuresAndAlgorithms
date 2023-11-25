import org.junit.jupiter.api.Test;

/**
 * 动态数组
 */
public class DynamicArray {
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
        add(size,element);
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
    public void add(int index,int element) throws IllegalArgumentException{
        if (index>size) throw new IllegalArgumentException("index>size越界");

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






    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addList(1);
        dynamicArray.addList(2);
        dynamicArray.addList(3);
        dynamicArray.addList(4);
//        dynamicArray.addList(5);

        dynamicArray.add(2,5);

        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }


}

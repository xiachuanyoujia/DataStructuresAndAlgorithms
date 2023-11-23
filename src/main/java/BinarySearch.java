import org.junit.jupiter.api.Test;

public class BinarySearch {

    /**
     * 二分查找基础版
     * Params:  a-待查找的升序数组
     *          target-待查找的目标值
     * Returns:
     *          找到则返回索引
     *          找不到返回-1
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 45, 46, 74, 89};
        System.out.println(binarySearchBasic(a, 7));
        System.out.println(binarySearchBasic(a, 13));
        System.out.println(binarySearchBasic(a, 30));
        System.out.println(binarySearchBasic(a, 74));

    }

    @Test
    public void test2() {
        int[] a = {7, 13, 21, 30, 38, 45, 46, 74, 89};
        System.out.println(binarySearchBasic(a, 55));
        System.out.println(binarySearchBasic(a, 0));
    }
}

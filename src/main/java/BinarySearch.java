import org.junit.jupiter.api.Test;

public class BinarySearch {

    /**
     * 二分查找基础版
     * Params:  a-待查找的升序数组
     * target-待查找的目标值
     * Returns:
     * 找到则返回索引
     * 找不到返回-1
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
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


    /**
     * 二分查找改动版
     * Params:  a-待查找的升序数组
     * target-待查找的目标值
     * Returns:
     * 找到则返回索引
     * 找不到返回-1
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    @Test
    public void test3() {
        int[] a = {7, 13, 21, 30, 38, 45, 46, 74, 89};
        System.out.println(binarySearchAlternative(a, 7));
        System.out.println(binarySearchAlternative(a, 13));
        System.out.println(binarySearchAlternative(a, 30));
        System.out.println(binarySearchAlternative(a, 74));

    }

    @Test
    public void test4() {
        int[] a = {7, 13, 21, 30, 38, 45, 46, 74, 89};
        System.out.println(binarySearchAlternative(a, 55));
        System.out.println(binarySearchAlternative(a, 0));
    }

    /**
     * 二分查找 Leftmost
     * Params:  a-待查找的升序数组
     * target-待查找的目标值
     * Returns:
     * 找到则返回索引
     * 找不到返回-1
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                //记录候选位置
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    @Test
    public void test5() {
        int[] a = {1,2,5,5,5,6,8,9,10};
        System.out.println(binarySearchLeftmost1(a, 5));
        System.out.println(binarySearchLeftmost1(a, 9));

        System.out.println(binarySearchLeftmost1(a, 0));
        System.out.println(binarySearchLeftmost1(a, 12));
    }

    /**
     * 二分查找 Rightmost
     * Params:  a-待查找的升序数组
     * target-待查找的目标值
     * Returns:
     * 找到则返回索引
     * 找不到返回-1
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                //记录候选位置
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    @Test
    public void test6() {
        int[] a = {1,2,5,5,5,6,8,9,10};
        System.out.println(binarySearchRightmost1(a, 5));
        System.out.println(binarySearchRightmost1(a, 9));

        System.out.println(binarySearchRightmost1(a, 0));
        System.out.println(binarySearchRightmost1(a, 12));
    }
}

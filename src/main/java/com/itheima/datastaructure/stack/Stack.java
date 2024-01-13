package com.itheima.datastaructure.stack;

public interface Stack<E> {

    /**
     * 向栈顶压入元素
     * Params: value- 待压入值
     * Returns:压入成功返回true,否则返回false
     *
     * @param value
     * @return
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元索
     * Returns:栈非空返回栈顶元素,栈为空返回null
     *
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素,不弹出
     * Returns:栈非空返回栈顶元索,栈为空返回null
     *
     * @return
     */
    E peek();

    /**
     * 判断栈是否为空
     * Returns:空返回true,否则返回false
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * Returns:满返回true,否则返回false
     *
     * @return
     */
    boolean isFull();
}

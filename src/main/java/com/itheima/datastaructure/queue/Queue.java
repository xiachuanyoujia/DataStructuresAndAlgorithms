package com.itheima.datastaructure.queue;

public interface Queue<E> {
    /**
     * 向队列尾插入值
     * Params: value -待插入值
     * Returns:插入成功返回true,插入失败返回false
     *
     * @param value
     * @return
     */
    boolean offer(E value);

    /**
     * 从对列头获取值,并移除
     * Returns:如果队列非空返回对头值，否则返回null
     *
     * @return
     */
    E poll();

    /**
     * 从对列头获取值,不移除
     * Returns:如果队列非空返回对头值，否则返回null
     *
     * @return
     */
    E peek();

    /**
     * 检查队列是否为空
     * Returns:空返回true,否则返回false
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 检查队列是否已满
     * @return:true:满,false:未满
     */
    boolean isfull();
}

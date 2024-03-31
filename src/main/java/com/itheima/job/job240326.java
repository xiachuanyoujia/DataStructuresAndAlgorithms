package com.itheima.job;

import java.util.LinkedList;

public class job240326 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("西瓜");
        list.add("苹果");
        list.add("梨子");

        list.add("草莓");
        System.out.println(list);

        list.remove("西瓜");
        System.out.println(list);

        int index = list.indexOf("梨子");
        if (index != -1) {
            list.set(index, "香蕉");
        }
        System.out.println(list);

        if (list.contains("桃子")) {
            System.out.println("桃子在链表中");
        } else {
            System.out.println("桃子不在链表中");
        }
    }
}

package com.itheima.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDome1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20", "张翠山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41", "张三丰-男-100");

//        list1.stream().filter(name->name.startsWith("张")).filter(name->name.length()>=3).forEach(System.out::println);

//        list1.stream().forEach(s-> System.out.println(Integer.parseInt(s.split("-")[1])));

//        String[] array = list1.stream().toArray(value -> new String[value]);
//        System.out.println(Arrays.toString(array));

//        List<String> list = list1.stream()
//                .filter(item -> item.split("-")[1].equals("男"))
//                .collect(Collectors.toList());
//        System.out.println(list);

        Map<String, Integer> map = list1.stream()
                .filter(item -> item.split("-")[1].equals("男"))
                .collect(Collectors.toMap(k -> k.split("-")[0], v -> Integer.parseInt(v.split("-")[2])));
        System.out.println(map);

    }
}

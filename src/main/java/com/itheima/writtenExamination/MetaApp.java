package com.itheima.writtenExamination;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MetaApp {

    public int[] answer(int[] x) {
        int n = Math.min(x.length, 3);
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> st = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st.addLast(x[i]);
        }
        for (int i = 0; i < n; i++) {
            res.add(st.removeLast());
        }

        List<Integer> temp = new ArrayList<>();
        for (Integer item : res) {
            temp.addAll(Arrays.asList(item, item, item));
        }
        res.addAll(temp);
        Collections.sort(res);



        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void answerTest1() {
        System.out.println(Arrays.toString(answer(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(answer(new int[]{1, 2})));
    }
}

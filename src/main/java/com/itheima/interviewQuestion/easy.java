package com.itheima.interviewQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class easy {

    /**
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        if (astr == null) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        for (char str : astr.toCharArray()) {
            if (set.contains(str)) {
                return false;
            }
            set.add(str);
        }
        return true;
    }
}

package com.itheima.interviewQuestion;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class easy {

    /**
     * 面试题 01.02. 判定是否互为字符重排
     * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char s1str = s1.charAt(i);
            char s2str = s2.charAt(i);
            if (!map.containsKey(s1str)) {
                map.put(s1str, 0);
            }
            map.put(s1str, map.get(s1str) + 1);

            if (!map.containsKey(s2str)) {
                map.put(s2str, 0);
            }
            map.put(s2str, map.get(s2str) - 1);
        }
        Collection<Integer> values = map.values();
        if (values == null) {
            return false;
        }
        for (Integer s : values) {
            if (s != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void CheckPermutationTest() {
        easy easy = new easy();
        easy.CheckPermutation("abc", "bca");
    }

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

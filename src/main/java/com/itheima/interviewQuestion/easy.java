package com.itheima.interviewQuestion;

import org.junit.jupiter.api.Test;

import java.util.*;

public class easy {

    /**
     * 面试题 01.04. 回文排列
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                set.remove(s.charAt(i));
            }
        }
        int odd = 0;
        for (Character c : set) {
            if (++odd > 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void canPermutePalindromeTest() {
        easy easy = new easy();
        easy.canPermutePalindrome("aab");
    }

    /**
     * 面试题 01.03. URL化
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
        char[] c = S.toCharArray();
        int len = c.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                c[len--] = '0';
                c[len--] = '2';
                c[len--] = '%';
            } else {
                c[len--] = c[i];
            }
        }
        return new String(c, len + 1, c.length - 1 - len);
    }

    @Test
    public void replaceSpacesTest() {
        easy easy = new easy();
        easy.replaceSpaces("Mr John Smith    ", 13);
    }

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

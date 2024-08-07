package com.itheima.interviewQuestion;

import org.junit.jupiter.api.Test;

import java.util.*;

public class easy {

    /**
     * 面试题 01.07. 旋转矩阵
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * 不占用额外内存空间能否做到？
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len / 2); i++) {
            for (int j = 0; j < ((len + 1) / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }

    @Test
    public void rotateTest() {
        easy easy = new easy();
        easy.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }

    /**
     * 面试题 01.05. 一次编辑
     * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int fl = first.length(), sl = second.length();
        if (fl > sl) {
            return oneEditAway(second, first);
        }
        if (sl - fl > 1) {
            return false;
        }
        if (fl == sl) {
            int count = 0;
            for (int i = 0; i < fl; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count += 1;
                }
            }
            return count <= 1;
        }
        int i = 0, ofs = 0;
        while (i < fl) {
            if (first.charAt(i) != second.charAt(i + ofs)) {
                if (++ofs > 1) {
                    return false;
                }
            } else {
                i += 1;
            }
        }
        return true;
    }

    /**
     * 面试题 01.06. 字符串压缩
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }

    @Test
    public void compressStringTest() {
        easy easy = new easy();
        System.out.println(easy.compressString("aabcccccaa"));
    }

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

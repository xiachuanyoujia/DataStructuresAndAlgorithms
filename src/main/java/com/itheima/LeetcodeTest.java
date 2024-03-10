package com.itheima;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetcodeTest {

    /**
     * leetCode HOP100  39. 组合总和
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        //排序方便剪枝
        Arrays.sort(candidates);
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int start, int len, int target, ArrayDeque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            //剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    @Test
    public void testCombinationSum() {
        LeetcodeTest leetcodeTest = new LeetcodeTest();

        int[] candidates1 = {2,3,6,7};
        int target1 = 7;
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(2, 2, 3));
        expected1.add(Arrays.asList(7));
        assertEquals(expected1, leetcodeTest.combinationSum(candidates1, target1));

        int[] candidates2 = {2,3,5};
        int target2 = 8;
        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList(2, 2, 2, 2));
        expected2.add(Arrays.asList(2, 3, 3));
        expected2.add(Arrays.asList(3, 5));
        assertEquals(expected2, leetcodeTest.combinationSum(candidates2, target2));
    }

    /**
     * leetCode HOT100  22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtracking("", 0, 0, n, res);
        return res;
    }

    private void backtracking(String str, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            backtracking(str + "(", left + 1, right, n, res);
        }
        if (right < n) {
            backtracking(str + ")", left, right + 1, n, res);
        }
    }

    /**
     * leetCode HOP100  17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtraking(digits, 0, res, sb, numString);
        return res;
    }

    private void backtraking(String disgits, int num, LinkedList<String> res, StringBuilder sb, String[] numString) {
        if (num == disgits.length()) {
            res.add(sb.toString());
            return;
        }
        String curStr = numString[disgits.charAt(num) - '0'];
        for (int i = 0; i < curStr.length(); i++) {
            sb.append(curStr.charAt(i));
            backtraking(disgits, num + 1, res, sb, numString);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    /**
     * leetCode HOP100 11. 盛最多水的容器
     * <p>
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * min);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    @Test
    public void maxAreaTest() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
//        Main main = new Main();
        binaryToDecimal();
    }

    /**
     * 二进制转十进制
     */
    public static void binaryToDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个二进制数字：");
        String str = scanner.nextLine();
        if (!str.matches("[01]+")) {
            System.out.println("输入的不是二进制数字");
            return;
        }
//        int res = Integer.parseInt(str, 2);
//        System.out.println("十进制：" + res);
        int decimal = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(length - 1 - i);
            if (c == '1') {
                decimal += Math.pow(2, i);
            }
        }
        System.out.println("十进制：" + decimal);
        scanner.close();
    }

    /**
     * leetCode HOT100  617. 合并二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left = mergeTrees(root1.left, root2.left);
        merge.right = mergeTrees(root1.right, root2.right);
        return merge;
    }

    /**
     * leetCode HOT100  5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";

        char[] charArray = s.toCharArray();

        int left = 0;
        int right = 0;
        int len = 1;
        int maxLength = 1;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < charArray.length; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && charArray[left] == charArray[i]) {
                left--;
                len++;
            }
            while (right < charArray.length && charArray[right] == charArray[i]) {
                right++;
                len++;
            }
            while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
                left--;
                right++;
                len += 2;
            }
            if (len > maxLength) {
                maxLength = len;
                maxLeft = left + 1;
                maxRight = right - 1;
            }
            len = 1;
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    @Test
    public void testLongestPalindrome() {
        LeetcodeTest l = new LeetcodeTest();
        l.longestPalindrome("dasadaqw");
    }

    /**
     * leetCode HOT100  102. 二叉树的层序遍历
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    /**
     * leetcode  HOT100  4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int middel = sum / 2;
        int p1 = 0, p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i <= middel; i++) {
            if (p1 >= nums1.length) {
                list.add(nums2[p2]);
                p2++;
            } else if (p2 >= nums2.length) {
                list.add(nums1[p1]);
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
            } else {
                list.add(nums2[p2]);
                p2++;
            }
        }

        if (sum % 2 == 0) {//偶数
            double res = ((double) list.get(middel - 1) + (double) list.get(middel)) / 2;
            return res;
        }
        double res = list.get(middel);
        return res;
    }

    @Test
    public void testFindMedianSortedArrays() {
        LeetcodeTest l = new LeetcodeTest();
        System.out.println(l.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }

    /**
     * leetCode HOT100  3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, right = 0, max = 0;
        int[] count = new int[256]; // 创建一个数组来存储每个字符出现的次数
        char[] chars = s.toCharArray();

        while (right < s.length()) {
            char c = chars[right];
            count[c] += 1;
            right++;
            while (count[c] > 1) {
                max = Math.max(max, right - left - 1);
                char charLeft = chars[left];
                left++;
                count[charLeft] -= 1;
            }
        }
        return Math.max(right - left, max);
    }

    @Test
    public void TestLengthOfLongestSubstring() {
        LeetcodeTest leetcodeTest = new LeetcodeTest();
        System.out.println(leetcodeTest.lengthOfLongestSubstring("asdacxfrqwdadd"));
    }

    /**
     * leetCode 142. 环形链表 II
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode h = head;
        ListNode t = head;
        while (h != null && h.next != null) {
            h = h.next.next;
            t = t.next;
            if (h == t) {
                t = head;
                while (true) {
                    if (t == h) {
                        return t;
                    }
                    t = t.next;
                    h = h.next;
                }
            }
        }
        return null;
    }

    /**
     * leetCode HOT100  543.二叉树的直径
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * <p>
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * <p>
     * 两节点之间路径的 长度 由它们之间边数表示。
     *
     * @param root
     * @return
     */
    int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 1;
        dept(root);
        return ans - 1;
    }

    int dept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dept(root.left);
        int r = dept(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }


    /**
     * leetCode HOT100  283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    /**
     * leetCode HOT100 234. 回文链表
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        boolean isPalindrome = true;
        while (prev != null) {
            if (slow.val != prev.val) {
                isPalindrome = false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return isPalindrome;
    }


    /**
     * leetCode HOT100  121.买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int cost = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < cost) {
                cost = prices[i];
            }
            if (prices[i] - cost > profit) {
                profit = prices[i] - cost;
            }
        }
        return profit;
    }

    /**
     * leetCode HOT100  104.二叉树的最大深度
     * 给你一个二叉树的根节点 root ，请你返回其最大深度。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    /**
     * leetCode HOT100  101.对称二叉树
     * 给你一个二叉树的根节点 root ，如果二叉树的节点数为偶数，则返回 true ，否则返回 false 。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode lefe, TreeNode right) {
        if (lefe == null && right == null) {
            return true;
        }
        if (lefe == null || right == null) {
            return false;
        }
        if (lefe.val != right.val) {
            return false;
        }
        return dfs(lefe.left, right.right) && dfs(lefe.right, right.left);
    }

    /**
     * leetCode HOT100  226.翻转二叉树
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * leetCode HOT100  169.多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes = num == x ? votes + 1 : votes - 1;
        }
        return x;
    }

    /**
     * leetCode HOT100  94.二叉树的中序遍历
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }

    void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * leetCode HOT100  70.爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * leetCode  HOT100  136. 只出现一次的数字
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums)
            x ^= num;
        return x;
    }


    /**
     * leetCode HOT100  206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newListNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newListNode;
    }

    /**
     * leetCode HOT100  160.相交链表
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA, pb = headB;

        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }

    @Test
    public void testGetIntersectionNode() {
        // 创建交点
        ListNode intersectNode = new ListNode(8);
        intersectNode.next = new ListNode(4);
        intersectNode.next.next = new ListNode(5);

        // 创建链表A和链表B
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectNode;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectNode;

        // 创建解决方案对象
        LeetcodeTest solution = new LeetcodeTest();

        // 调用getIntersectionNode方法并验证结果
        ListNode result = solution.getIntersectionNode(headA, headB);

        // 打印值为1的节点的哈希地址值
        System.out.println(System.identityHashCode(headA.next));
        System.out.println(System.identityHashCode(headB.next.next));

        // 打印值为8的节点的哈希地址值
        System.out.println(System.identityHashCode(intersectNode));

        assertEquals(intersectNode, result);
    }

    /**
     * leetCode HOT100  141.环形链表
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * leetCode HOT100  21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void testMergeTwoLists() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        mergeTwoLists(list1, list2);
    }


    /**
     * leetCode HOT100  20.有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid() {
        String s = "()[]{}";
        isValid(s);
    }

}

package com.data.tructure.array.算法.leetcode;

import lombok.Getter;

import java.util.HashMap;

public class LeetCode {

    /**
     * 1. 两数之和 （简单）
     */
    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int result = target - nums[i];
                if (hashMap.containsKey(result)) {
                    return new int[]{hashMap.get(result), i};
                }
                hashMap.put(nums[i], i);
            }
            return null;
        }
    }

    /**
     * 2.两数相加 (中等)
     */
    static class addTwoNumbers {

        public static void main(String[] args) {

//            ListNode l3 = new ListNode(3);
            ListNode l2 = new ListNode(8);
//            l2.next = l3;
            ListNode l1 = new ListNode(9);
            l1.next = l2;

            ListNode l6 = new ListNode(1);
//            ListNode l5 = new ListNode(6);
//            l5.next = l6;
//            ListNode l4 = new ListNode(5);
//            l4.next = l5;
            ListNode listNode = addTwoNumbers2(l1, l6);
            getList(listNode);
        }

        /**
         * 循环
         *
         * @param l1
         * @param l2
         * @return
         */
        public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            ListNode cursor = root;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int l1Val = l1 != null ? l1.val : 0;
                int l2Val = l2 != null ? l2.val : 0;
                int sumVal = l1Val + l2Val + carry;
                carry = sumVal / 10;

                ListNode sumNode = new ListNode(sumVal % 10);
                cursor.next = sumNode;
                cursor = sumNode;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            return root.next;
        }

        /**
         * 循环
         *
         * @param l1
         * @param l2
         * @return
         */
        public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
            int goOne = 0;
            ListNode head = null;
            ListNode tail = null;
            while (l1 != null || l2 != null || goOne != 0) {
                int x = l1 != null ? l1.val : 0;
                int y = l2 != null ? l2.val : 0;
                l1 = l1 != null ? l1.next : l1;
                l2 = l2 != null ? l2.next : l2;
                //  [9,3,4]
                //  [1,2]
                int sum = x + y + goOne;
                if (goOne > 0) {
                    goOne = 0;
                }
                if (sum >= 10) {
                    goOne = 1;
                    sum = sum % 10;
                }


                ListNode cur = new ListNode(sum);
                if (head == null) {
                    head = cur;
                    tail = cur;
                } else {
                    tail.next = cur;
                    tail = cur;
                }
            }
            return head;
        }

        /**
         * 递归方式
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) return null;
            if (l1 == null) l1 = new ListNode(0);
            l1.val += l2 == null ? 0 : l2.val;
            if (l1.val > 9) {
                l1.val = l1.val % 10;
                if (l1.next == null)
                    l1.next = new ListNode(1);
                else
                    l1.next.val += 1;
                l1.next = addTwoNumbers4(l1.next, l2 == null ? null : l2.next);
            } else {
                l1.next = addTwoNumbers4(l1.next, l2 == null ? null : l2.next);
            }
            return l1;
        }
    }

    /**
     * 3. 无重复字符的最长子串 (中等)
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    static class Substring {
        public static int lengthOfLongestSubstring(String s) {
            int max = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                boolean b = hashMap.containsKey(c);
                max = hashMap.size() > max ? hashMap.size() : max;
                if (b) {
                    hashMap.clear();
                }
                hashMap.put(c, 1);
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println("max str abcabcbb:" + lengthOfLongestSubstring("abcabcbb"));
            System.out.println("max str bbbbb:" + lengthOfLongestSubstring("bbbbb"));
            System.out.println("max str pwwkew:" + lengthOfLongestSubstring("pwwkew"));
        }
    }


    @Getter
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void getList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

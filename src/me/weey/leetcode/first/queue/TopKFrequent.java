package me.weey.leetcode.first.queue;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n是数组大小。
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) {
            Integer key = dict.get(num);
            if (null == key) {
                key = 1;
            } else {
                key++;
            }
            dict.put(num, key);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dict.get(o1) - dict.get(o2);
            }
        });
        for (Integer key : dict.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (dict.get(key) > dict.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty() && i < k) {
            result[i] = priorityQueue.remove();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}

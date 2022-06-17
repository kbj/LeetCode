package me.weey.leetcode.first.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 * [2,3,4]的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * @author pc
 */
public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /**
     * 需要使用最大堆和最小堆方式解决，保证 0 <= 最大堆长度-最小堆长度 <= 1
     */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        // 大堆为空或小于最大值放入大堆，其他情况放入小堆
        if (this.maxHeap.isEmpty() || maxHeap.peek() >= num) {
            this.maxHeap.add(num);
        } else {
            this.minHeap.add(num);
        }

        // 检查 0 <= 最大堆长度-最小堆长度 <= 1 是否满足
        if (this.minHeap.size() > this.maxHeap.size()) {
            this.maxHeap.add(this.minHeap.peek());
            this.minHeap.remove();
        } else if (this.maxHeap.size() - this.minHeap.size() > 1) {
            this.minHeap.add(this.maxHeap.peek());
            this.maxHeap.remove();
        }
    }

    public double findMedian() {
        if (this.maxHeap.size() > this.minHeap.size()) {
            // 奇数
            return (double)(this.maxHeap.peek());
        } else {
            return (double) (this.maxHeap.peek() + this.minHeap.peek()) / 2;
        }
    }
}

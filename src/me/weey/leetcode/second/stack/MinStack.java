package me.weey.leetcode.second.stack;

import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用3 * 104次
 *
 * @author pc
 */
public class MinStack {
    private LinkedList<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int val) {
        // 当前是一个小值的节点，先把当前的最小值放入栈
        if (val <= this.min) {
            this.stack.push(this.min);
            this.min = val;
        }
        this.stack.push(val);
    }

    public void pop() {
        // 删除最后一位
        if (this.stack.pop() == this.min) {
            // 出栈了最小值，按入栈定义的规则，那么再出栈一次就为那值之前的最小值
            this.min = this.stack.pop();
        }
    }

    public int top() {
        return this.stack.get(0);
    }

    public int getMin() {
        return this.min;
    }
}

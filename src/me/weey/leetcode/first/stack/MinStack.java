package me.weey.leetcode.first.stack;

import java.util.Stack;

/**
 * @author Weey
 * @description:设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * @date 2021-06-07 17:24
 */
public class MinStack {
    public static void main(String[] args) {

    }
    static class MinStacks {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int val) {
            stack1.push(val);
            if (stack2.empty() || getMin() >= val) {
                stack2.push(val);
            }
        }

        public void pop() {
            if (stack1.pop() == getMin()) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}

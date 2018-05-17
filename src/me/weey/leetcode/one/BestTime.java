package me.weey.leetcode.one;

/**
 * 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。
 * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
 * 给出一个数组样例[2,1,2,0,1], 返回 2
 * Created by WeiKai on 2018/03/12.
 */
public class BestTime {
    public static void main(String[] args) {
//        int[] ints = {1, 2, 4};         //3
//        int[] ints = {3,2,6,5,0,3};   //7
        int[] ints = {1, 4, 2};         //3
//        int[] ints = {2,1,2,0,1};       //2
        int i = maxProfit(ints);
        System.out.println(i);
    }

    private static int maxProfit(int[] prices) {
        int max = 0;                            //计算总额
        int buyIndex = Integer.MIN_VALUE;       //买股票的那天
        int saleIndex = Integer.MIN_VALUE;      //卖股票的那天
        boolean isBuy = false;                  //标记当前的循环状态，是否已经购买股票了

        for (int i=0; i<prices.length - 1; i++) {
            //如果今天比下一天价钱小，那就说明可以买入
            if (prices[i] < prices[i+1]) {
                //判断买入的那天必须要大于或等于卖出的那天 并且 加上当前并没有购买股票
                if (buyIndex >= saleIndex && !isBuy) {
                    //买入股票，标记买的那天
                    buyIndex = i;
                    //修改购买状态为已购买
                    isBuy = true;
                }
            }

            //如果今天的价钱比明天的价钱更高，那就说明可以判断是否可以卖了，同时，当处于数组的倒数第二个数的时候，也要考虑卖了
            if ((i+1 == prices.length - 1) || prices[i] > prices[i+1]) {
                //buyIndex < 0为了排除初始状态，当buyIndex == saleIndex时表示当天已经卖掉了，就是已经是未购买状态了
                if (buyIndex < 0 || buyIndex == saleIndex) {
                    continue;
                }
                //当处于数组倒数第二个的时候，判断是倒数第一个数更大还是当前倒数第二个数
                if ((i+1 == prices.length - 1) && (prices[i+1] > prices[i])) {
                    //倒数第一个更大
                    saleIndex = i + 1;
                } else {
                    //当前数
                    saleIndex = i;
                }
                //卖出计算收益
                max += (prices[saleIndex] - prices[buyIndex]);
                //改变购买状态
                isBuy = false;
                //让购买天数重置为卖出天数
                buyIndex = saleIndex;
            }
        }

        return max;
    }
}

package main.java.algorithm;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *股票买卖，只能完成一笔交易
 * 找出差值最大且大的数在小的数后面的两个数，并计算其差值
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min=102400;
        int max=102400;
        int result=0;
        for (int price:prices) {
            if (price<min){
                min=price;
                max=price;
            }else if (price>max){
                max=price;
            }
            if (max-min>result)
                result=max-min;
        }
        return result;
    }
    //论坛解，记录当前值以及过去的最大值，每次只算相邻两个数的差值，从而找到差值最大的两个数
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            //小于0时重置，因为找到了比之前更低的点可以去购入
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    //只需要记录最小值，然后中间遍历的数减去最小值，看与历史值谁大
    public int maxProfit3(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price: prices) {
            min = Math.min(min, price);
            max = Math.max(price - min, max);
        }
        return max;
    }
}

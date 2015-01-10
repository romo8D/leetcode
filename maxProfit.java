/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
 
 public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int ret = 0, bottom = prices[0];
        for(int i=1;i<prices.length;i++)
        {
            bottom = Math.min(bottom, prices[i]);
            ret = Math.max(ret, prices[i] - bottom);
        }
        return ret;
    }
}

package dp;

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.


 */
public class SellOrBuyStockKTimes {
    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int k = 2;
        System.out.println(maxProfit(prices, k));
    }

    // Utility function for recursive profit calculation
    static int maxProfitUtil(int i, int k, int buy, int[] prices) {

        // Base case
        if (k <= 0 || i >= prices.length)
            return 0;

        int res = 0;

        // If we can buy, choose to buy or skip
        if (buy == 1)
            res = Math.max(maxProfitUtil(i + 1, k, 0, prices) - prices[i],
                    maxProfitUtil(i + 1, k, 1, prices));

            // If we can sell, choose to sell or skip
        else
            res = Math.max(prices[i] + maxProfitUtil(i + 1, k - 1, 1, prices),
                    maxProfitUtil(i + 1, k, 0, prices));

        return res;
    }

    // Function to return maximum profit with k transactions
    static int maxProfit(int[] prices, int k) {
        // buy => 1 & sell => 0
        return maxProfitUtil(0, k, 1, prices);
    }

}

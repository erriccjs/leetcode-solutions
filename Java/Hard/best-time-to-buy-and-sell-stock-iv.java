//Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
package Java.Hard;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        // Initialize arrays to track the maximum profit for each transaction.
        int[] buy = new int[k];
        int[] profit = new int[k];

        // Initialize the buy prices to represent the highest possible value and the
        // profit to represent the lowest possible value.
        for (int i = 0; i < k; i++) {
            buy[i] = Integer.MAX_VALUE;
            profit[i] = Integer.MIN_VALUE;
        }

        // Iterate through the prices array to calculate the maximum profit for each
        // transaction.
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                // Update the buy price if a lower value is found.
                buy[i] = Math.min(buy[i], price - (i > 0 ? profit[i - 1] : 0));
                // Update the profit if a higher value is found.
                profit[i] = Math.max(profit[i], price - buy[i]);
            }
        }
        return profit[k - 1];
    }
}

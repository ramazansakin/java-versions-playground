package org.example.LeetCode150;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        int i = 0, buy, sell, profit = 0, n = prices.length - 1;
        while (i < n) {
            while (i < n && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < n && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit2 solution = new MaxProfit2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices)); // Output should be 7
    }

}

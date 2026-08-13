class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                // Update the lowest buying price seen so far
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // Update max profit if selling today yields a higher return
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
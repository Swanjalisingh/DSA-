
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Step 1: Find maximum factor
        int maxF = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxF = Math.max(maxF, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 2: Count frequency of each factor
        int[] freq = new int[maxF + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 3: Count all multiples of each factor
        int[] cnt = new int[maxF + 1];

        for (int i = 1; i <= maxF; i++) {
            for (int j = i; j <= maxF; j += i) {
                cnt[i] += freq[j];
            }
        }

        // Step 4: Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        long ans = 0;
        long remaining = budget;

        // Step 5: Buy items which give free items
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            // Each item type can unlock cnt[factor] - 1
            // different free item types
            int gain = cnt[factor] - 1;

            // Bonus purchase is not profitable anymore
            if (2L * minPrice < price) {
                break;
            }

            if (gain == 0) {
                continue;
            }

            // Number of bonus copies we can purchase
            long take = Math.min(
                gain,
                remaining / price
            );

            ans += 2 * take;
            remaining -= take * price;
        }

        // Step 6: Spend remaining budget on cheapest item
        ans += remaining / minPrice;

        return (int) ans;
    }
}

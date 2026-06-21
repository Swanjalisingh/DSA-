class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);   // sort prices in increasing order
        int count = 0;

        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
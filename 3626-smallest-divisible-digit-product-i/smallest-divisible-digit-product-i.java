class Solution {
    public int smallestNumber(int n, int t) {
        if (product(n) % t == 0) {
            return n;
        }
        return smallestNumber(n + 1, t);
    }

    public int product(int n) {
        if (n == 0) {
            return 1;
        }

        return (n % 10) * product(n / 10);
    }
}
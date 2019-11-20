public class Solution {
    public int numTrees(int n) {
        if (n <= 0)
            return 0;
        return calc(n, new HashMap<Integer, Integer>());
    }

    private int calc(int n, Map<Integer, Integer> cache) {
        if (n <= 1)
            return 1;
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int sum = 0;
            for (int root = 1; root <= n; root++) {
                int left = calc(root - 1, cache);
                int right = calc(n - root, cache);
                sum += left * right;
                cache.put(n, sum);
            }

            return sum;
        }
    }
}

public class Solution {
    public int NumTrees (int n) {
        var dict = new Dictionary<int, int> () { { 0, 1 }, { 1, 1 } };
        return Calc (n, dict);
    }

    private int Calc (int n, Dictionary<int, int> dict) {
        if (dict.ContainsKey (n)) {
            return dict[n];
        } else {
            int sum = 0;
            for (int root = 1; root <= n; root++) {
                var left = Calc (root - 1, dict);
                var right = Calc (n - root, dict);
                sum += left * right;
            }

            if (!dict.ContainsKey (n))
                dict.Add (n, sum);

            return sum;
        }
    }
}
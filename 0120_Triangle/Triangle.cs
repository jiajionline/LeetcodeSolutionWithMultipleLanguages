public class Solution {
    public int MinimumTotal (IList<IList<int>> triangle) {
        if (triangle == null || triangle.Count == 0) return 0;
        var dp = new int[triangle.Count + 1];

        for (int i = triangle.Count - 1; i >= 0; i--) {
            var tempList = triangle[i];
            for (int j = 0; j < tempList.Count; j++) {
                dp[j] = Math.Min (dp[j], dp[j + 1]) + tempList[j];
            }

        }

        return dp[0];
    }
}
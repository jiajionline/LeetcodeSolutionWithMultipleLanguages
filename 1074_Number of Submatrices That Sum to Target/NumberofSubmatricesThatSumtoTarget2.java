class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length+1, n = matrix[0].length+1;

    // compute 2D prefix sum with padding
    int[][] ps = new int[m][n];
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    int ans = 0, currSum;
    Map<Integer, Integer> map = new HashMap();
    
    for (int row = 1; row < m; row++) {
      for (int row2 = row; row2 < m; row2++) {
        map.clear();
        map.put(0, 1);
        for (int col = 1; col < n; col++) {
          currSum = ps[row2][col] - ps[row - 1][col];
          ans += map.getOrDefault(currSum - target, 0);
          map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
      }
    }

    return ans;
  }
}
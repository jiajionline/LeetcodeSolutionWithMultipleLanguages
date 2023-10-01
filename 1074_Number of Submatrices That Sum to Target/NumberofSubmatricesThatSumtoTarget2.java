class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length+1, n = matrix[0].length+1;
        int[][] presum = new int[m][n];
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int ans = 0;
        for(int startRow=1;startRow<m;startRow++) {
            for(int endRow=startRow;endRow<m;endRow++) {
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                for(int col=1;col<n;col++) {
                    int currSum = presum[endRow][col] - presum[startRow-1][col];
                    ans += map.getOrDefault(currSum - target, 0);
                    map.put(currSum, map.getOrDefault(currSum, 0)+1);
                }
            }
        }
        return ans;

    }
}
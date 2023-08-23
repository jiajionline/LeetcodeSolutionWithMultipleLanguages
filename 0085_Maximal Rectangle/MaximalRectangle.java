class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0){
                    arr[i][j] = matrix[i][j] - '0';
                }else{
                    arr[i][j] = matrix[i][j] == '0' ? 0 : arr[i-1][j] + 1;
                }
            }
        }

        for(int i=0;i<m;i++) {
            int[] rows = new int[n+1];
            for(int j=0;j<n;j++) {
                rows[j] = arr[i][j];
            }

            ans = Math.max(ans, maxRectangle(rows));
        }
        return ans;
    }

    private int maxRectangle(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<arr.length;i++) {
            while(stack.size() > 0 && arr[i] <= arr[stack.peek()]){
                int prev = stack.pop();
                int h = arr[prev];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }
}
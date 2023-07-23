class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0;i<matrix.length;i++) {
            pq.offer(new int[]{matrix[i][0],i,0});
        }

        int ans = 0;
        while(k-- > 0){
            int[] v = pq.poll();
            ans = v[0];
            int row = v[1];
            int col = v[2];
            if(col+1 < matrix[row].length) {
                pq.offer(new int[]{matrix[row][col+1], row, col+1});
            }
        }

        return ans;
    }
}
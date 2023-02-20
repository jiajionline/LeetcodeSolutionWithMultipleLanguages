class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int m = matrix.length;
        
        for(int i=0;i<m && i<k;i++) {
            pq.add(new int[]{i,0});
        }
        
        int count = 0;
        
        while(pq.size() > 0) {
            int[] cell = pq.poll();
            if(++count == k) return matrix[cell[0]][cell[1]];
            
            if(cell[1] < matrix[0].length-1) {
                pq.add(new int[]{cell[0], cell[1]+1});
            }
        }
        
        return -1;
    }
}
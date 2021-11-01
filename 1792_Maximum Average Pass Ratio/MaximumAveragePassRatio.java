class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        // min heap.
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0])); 
        for (int[] c : classes) {
            double pass = c[0], total = c[1];
            pq.offer(new double[]{profit(pass, total), pass, total});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            double pass = top[1], total = top[2];
            pq.offer(new double[]{profit(pass+1, total+1), pass+1, total+1});
        }
        double ans = 0.0d;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            double pass = top[1], total = top[2];
            ans += pass/total;
        }
        return ans / classes.length;
    }
    
    private double profit(double pass, double total) {
        return (pass + 1) / (total + 1) - pass / total;
    }
}
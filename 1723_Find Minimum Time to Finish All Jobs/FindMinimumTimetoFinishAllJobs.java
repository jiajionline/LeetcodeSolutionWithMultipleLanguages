class Solution {
    private int ans = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        dfs(jobs, jobs.length - 1, new int[k]);
        return ans;
    }
    
    private void dfs(int[] jobs, int index, int[] sum) {
        if(index < 0) {
            ans = Math.min(ans, Arrays.stream(sum).max().getAsInt());
            return;
        }
        
        if(Arrays.stream(sum).max().getAsInt() >= ans) return; // current max value already is greater than ans, no need to calculate
        
        for(int i=0;i<sum.length;i++) {
            if(i > 0 && sum[i] == sum[i-1]) continue; // no need to assign for this case since already calculated
            sum[i] += jobs[index];
            dfs(jobs, index-1, sum);
            sum[i] -= jobs[index];
        }
    }
}
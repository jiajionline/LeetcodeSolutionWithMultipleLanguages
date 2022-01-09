public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        var N = difficulty.Length;
        var list = new List<int[]>(N);
        for(int i=0;i<N;i++)
            list.Add(new int[]{difficulty[i], profit[i]});
        
        list.Sort((a,b)=> a[0] - b[0]);
        Array.Sort(worker);
        
        var ans = 0;
        var j = 0;
        var best = 0;
        
        foreach(var level in worker)
        {
            while( j < N && level >= list[j][0])
                best = Math.Max(best, list[j++][1]);
            ans += best;
        }
        
        return ans;
    }
}
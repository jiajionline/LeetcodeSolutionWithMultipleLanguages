public class Solution {
    private int[] mem = new int[50001];
    
    public int JobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        var n = startTime.Length;
        //only one job
        if(n == 1) return profit[0];
        
        var jobs = new List<Job>(n);
                
        for(int i=0;i<n;i++)
        {
            var job = new Job();
            job.StartTime = startTime[i];
            job.EndTime = endTime[i];
            job.Profit = profit[i];
            jobs.Add(job);
        }
        
        jobs.Sort((a,b) => {return a.StartTime.CompareTo(b.StartTime);});
        Array.Fill(mem, -1);
        
        return FindMaxProfit(jobs, n, 0);
    }
    
    private int FindMaxProfit(List<Job> jobs, int n, int index)
    {
        if(index == n) return 0;
        if(mem[index] != -1) return mem[index];
        
        var nextIndex = FindNextJob(jobs, jobs[index].EndTime);
        var maxProfit = Math.Max(FindMaxProfit(jobs, n, index+1), jobs[index].Profit + FindMaxProfit(jobs, n, nextIndex));
        
        mem[index] = maxProfit;
        return maxProfit;
    }
    
    // using binary search to find the first job which StartTime >= lastEndTime
    // [l,r)
    private int FindNextJob(List<Job> jobs, int lastEndTime)
    {
        var l = 0;
        var r = jobs.Count ;
        
        while(l < r)
        {
            var mid = (r - l) / 2 + l;
            if(jobs[mid].StartTime >= lastEndTime)
            {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        
        return l;
    }
}


public class Job
{
    public int StartTime;
    public int EndTime;
    public int Profit;
}
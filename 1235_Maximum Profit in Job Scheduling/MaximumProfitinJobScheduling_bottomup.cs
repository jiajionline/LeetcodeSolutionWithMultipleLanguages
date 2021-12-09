public class Solution {
    private int[] _mem = new int[50001];
    
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
        
        return FindMaxProfit(jobs, n);
    }
    
    private int FindMaxProfit(List<Job> jobs, int n)
    {
        for(var index = n - 1; index >=0 ; index--)
        {
            var currProfit = 0;
            var currJob = jobs[index];
            var nextIndex = FindNextJob(jobs, currJob.EndTime);
            
            if(nextIndex < n)
            {
                currProfit = currJob.Profit + _mem[nextIndex];
            }else{
                currProfit = currJob.Profit;
            }
            
            if(index == n - 1)
            {
                _mem[index] = currProfit;
            }else{
                _mem[index] = Math.Max(currProfit, _mem[index+1]);
            }
        }
        
        return _mem[0];
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
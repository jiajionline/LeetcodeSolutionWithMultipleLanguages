public class HitCounter {
    private const int limit = 300;
    private int[] hits = new int[limit];
    private int[] time = new int[limit];
    public HitCounter() {
        
    }
    
    public void Hit(int timestamp) {
        var index = timestamp % limit;
        if(time[index] != timestamp)
        {
            time[index] = timestamp;
            hits[index] = 1;
        }else{
            hits[index]++;
        }
    }
    
    public int GetHits(int timestamp) {
        var smallest = timestamp - limit;
        var cnt = 0;
        for(int i=0;i<limit;i++)
        {
            if(time[i] > smallest)
                cnt += hits[i];
        }
        
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.Hit(timestamp);
 * int param_2 = obj.GetHits(timestamp);
 */
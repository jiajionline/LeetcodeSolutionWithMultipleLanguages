class HitCounter {
    private final int limit = 300;
    private int[] hitTime = new int[limit];
    private int[] count = new int[limit];

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        int index = timestamp % limit;
        if(hitTime[index] != timestamp) {
            hitTime[index] = timestamp;
            count[index] = 1;
        }else{
            count[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int ans = 0;
        int smallest = timestamp - limit;
        for(int i=0;i<hitTime.length;i++) {
            if(hitTime[i] > smallest) {
                ans += count[i];
            }
        }
        
        return ans;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
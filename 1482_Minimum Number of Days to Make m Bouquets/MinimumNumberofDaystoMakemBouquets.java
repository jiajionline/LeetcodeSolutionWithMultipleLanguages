class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        // not enough flowers to make m bouquets
        if(m * k > n) return -1;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            l = Math.min(l, bloomDay[i]);
            r = Math.max(r, bloomDay[i])+1;
        }
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(isValid(mid, bloomDay, m , k)){
                r = mid;
                ans = mid;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    
    private boolean isValid(int day, int[] bloomDay, int m, int k) {
        int consective = 0;
        int bouquets = 0;
        for(int v : bloomDay){
            if(v > day){
                consective = 0;
            }else{
                consective++;
                if(consective == k){
                    consective=0;
                    bouquets++;
                }
            }
        }
        
        return bouquets >= m;
    }
}
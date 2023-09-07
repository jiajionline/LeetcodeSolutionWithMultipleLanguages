class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int v : piles) r = Math.max(r, v);
       
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(hours(piles, mid) <= h) {
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private int hours(int[] piles, int countPerHour) {
        int hours = 0;
        for(int v : piles) {
            hours += v / countPerHour;
            if(v % countPerHour > 0) hours++;
        }
        return hours;
    }
}
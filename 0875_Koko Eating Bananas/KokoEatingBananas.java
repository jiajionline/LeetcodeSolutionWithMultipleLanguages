class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt()+ 1;
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(totalHour(piles, mid) > h) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        
        return l;
    }
    
    private int totalHour(int[] piles, int speed) {
        int hours = 0;
        for(int p : piles) {
            if(p <= speed) hours++;
            else {
                hours += (p / speed);
                hours += (p % speed > 0 ? 1 : 0);
            }
        }
        return hours;
    }
}
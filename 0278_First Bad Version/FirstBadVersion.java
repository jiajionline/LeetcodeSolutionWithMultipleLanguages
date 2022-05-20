/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// [l, R)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1;
        long r = (long)n + 1;
        while(l < r) {
            long mid = (r-l)/2 + l;
            if(isBadVersion((int)mid))
                r = mid;
            else
                l = mid + 1;
        }
        
        return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l;
    }
}
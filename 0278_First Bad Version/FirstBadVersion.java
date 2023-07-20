/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// [l, R)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1, r = (long)n + 1;
        while(l < r) {
            int mid = (int)((r-l)/2 + l);
            if(isBadVersion(mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return (int)l;
    }
}
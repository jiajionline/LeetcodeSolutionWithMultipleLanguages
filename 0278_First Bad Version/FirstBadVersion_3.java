/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// [l,r)
// technicially if we go [l,r), r should be n + 1, but overflow. For this case, that's also fine if r = n
// since if last version is the first bad version, l eventually is equals to mid + 1, for this case is n.
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(isBadVersion(mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find peak
        int l = 0, r = mountainArr.length() - 1;
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        
        int peak = l;
        
        l = 0;
        r = peak+1;
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(mountainArr.get(mid) >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        
        if(mountainArr.get(l) == target) return l;
        
        l = peak + 1;
        r = mountainArr.length();
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(mountainArr.get(mid) <= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        
        if(l < mountainArr.length() && mountainArr.get(l) == target) return l;
        
        return -1;
    }
}
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(Math.max(m,n) > Math.min(m,n)*6) return -1;
        int sum1 = sum(nums1), sum2 = sum(nums2);
        if(sum1 > sum2) return minOperations(nums2, nums1);
        int ans = 0, p1 = 0, p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        reverse(nums2);

        while(sum1 != sum2) {
            int d1 = p1 == nums1.length ? 0 : 6 - nums1[p1];
            int d2 = p2 == nums2.length ? 0 : nums2[p2] - 1;
            int change = Math.min(Math.abs(sum2 - sum1), Math.max(d1,d2));
            if(d1 >= d2) {
                sum1 += change;
                p1++;
            }else{
                sum2 -= change;
                p2++;
            }
            ans++;
        }
        return ans;
    }

    private int sum(int[] nums){
        int sum = 0;
        for(int v : nums) sum+=v;
        return sum;
    }

    private void reverse(int[] nums) {
        int l = 0 , r = nums.length-1;
        while(l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    private int majorityElement(int[] nums, int l , int r) {
        if(l == r) return nums[l];
        int mid = (r-l)/2 + l;
        int left = majorityElement(nums, l, mid);
        int right = majorityElement(nums, mid+1, r);
        if(left == right) return left;
        int cntLeft = count(nums,l, mid, left);
        int cntRight = count(nums, mid+1, r, right);
        if(cntLeft > cntRight) return left;
        else return right;
    }
    
    private int count(int[] nums, int l , int r, int v){
        int c = 0;
        for(int i=l;i<=r;i++)
            if(nums[i] == v) c++;
        return c;
    }
}
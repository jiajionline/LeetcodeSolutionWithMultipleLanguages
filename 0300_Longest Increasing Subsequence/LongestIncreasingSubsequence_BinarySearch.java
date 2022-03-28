class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
            int pos = lowerBound(list, nums[i]);
            if(pos == list.size()) {
                list.add(nums[i]);
            }else {
                list.set(pos, nums[i]);
            }
        }
        
        return list.size();
    }
    
    private int lowerBound(List<Integer> list, int target) {
        int l = 0;
        int r = list.size();
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(list.get(mid) < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        
        return l;
    }
}
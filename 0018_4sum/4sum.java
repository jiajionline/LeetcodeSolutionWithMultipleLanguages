class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 3) return ans;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                
                int l = j+1;
                int r = nums.length - 1;
                while(l < r)
                { 
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if( sum == target) {
                        ArrayList<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum < target) 
                        l++;
                    else
                        r--;
                }
            }
        }
            
        
        return ans;
    }
}
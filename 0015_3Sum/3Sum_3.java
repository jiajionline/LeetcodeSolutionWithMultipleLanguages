class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int k=0;k<n-2;k++) {
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1, j = n-1;
            while(i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ans.add(list);
                    i++;
                    j--;
                }else if(sum > 0) {
                    j--;
                }else{
                    i++;
                }
                while(i > k+1 && i < j && nums[i] == nums[i-1]) i++;
                while(j < n-1 && i < j && nums[j] == nums[j+1]) j--;
            }
        }

        return ans;
    }
}
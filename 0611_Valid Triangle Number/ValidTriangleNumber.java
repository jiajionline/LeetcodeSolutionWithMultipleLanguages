class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length <=2) return 0;
        int ans = 0;
        Arrays.sort(nums);
        
        for(int c=nums.length-1;c >= 2 ;c--)
        {
            int a = 0;
            int b = c-1;
            
            while(b > a)
            {
                if(nums[a] + nums[b] > nums[c]){
                    ans += b-a;
                    b--;
                }else{
                    a++;
                }
            }
        }
        
        return ans;
        
    }
}
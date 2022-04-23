class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<nums.length;i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if(map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        
        return ans;
    }
}
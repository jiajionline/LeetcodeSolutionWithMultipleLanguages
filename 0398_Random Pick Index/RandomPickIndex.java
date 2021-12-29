class Solution {
    private HashMap<Integer, ArrayList<Integer>> _map;
    private Random _rand;

    public Solution(int[] nums) {
        _rand = new Random();
        _map = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(!_map.containsKey(nums[i])) _map.put(nums[i], new ArrayList<Integer>());
            _map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> list = _map.get(target);
        return list.get(_rand.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
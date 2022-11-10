class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            if(upper - lower == 0){
                ans.add(String.valueOf(lower));
            }else{
                ans.add(lower + "->" +upper);    
            }
            
            return ans;
        }
        
        List<Integer> list = new ArrayList<>(nums.length + 2);
        list.add(lower-1);
        for (int i : nums) list.add(i);
        list.add(upper+1);
        
        for(int i=1;i<list.size();i++) {
            int v = list.get(i) - list.get(i-1);
            if(v == 2){
                ans.add(String.valueOf(list.get(i-1) + 1));
            }else if(v > 2){
                ans.add((list.get(i-1) + 1) + "->" + (list.get(i)-1));
            }
        }
        
        return ans;
    }
}
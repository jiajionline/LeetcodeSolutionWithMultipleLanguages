class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int v : nums){
            countMap.put(v, countMap.getOrDefault(v,0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() > nums.length / 2) return entry.getKey();
        }
        
        return -1;
    }
}
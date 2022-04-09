class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for(int key: hm.keySet()){
            int frequency = hm.get(key);
            if(bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        
        int[] ans = new int[k];
        int index = 0;
        for(int pos = bucket.length-1; pos >= 0; pos--){
            if(bucket[pos] != null){
                for(int i = 0; i < bucket[pos].size() && index < k; i++)
                    ans[index++] = bucket[pos].get(i);
            }
        }
        return ans;
  }
}

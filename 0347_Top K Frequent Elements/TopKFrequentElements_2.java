class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int v: nums) {
          count.put(v, count.getOrDefault(v, 0) + 1);
        }
        
        List<Integer>[] freqList = new List[nums.length + 1];
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int v = entry.getKey();
            int freq = entry.getValue();
            if(freqList[freq] == null) freqList[freq] = new ArrayList<Integer>();
            freqList[freq].add(v);
        }
        
        int[] ans = new int[k];
        int index = 0;
        for(int i=freqList.length - 1 ; i >= 0 ; i--) {
            if(freqList[i] != null) {
                for(int v : freqList[i]) {
                    if(index < k) {
                        ans[index++] = v;
                    }
                }
                
                if(index >= k) break;
            }
        }
        
        return ans;
    }
}
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] update : updates) {
            map.put(update[0], map.getOrDefault(update[0], 0) + update[2]);
            map.put(update[1]+1, map.getOrDefault(update[1]+1, 0) - update[2]);
        }
        
        int[] ans = new int[length];
        int accumalate = 0;
        for(int i=0;i<ans.length;i++) {
            if(map.containsKey(i)) {
                accumalate += map.get(i);
            }
            
            ans[i] = accumalate;
        }
        
        return ans;
    }
}
class Solution {
     public int totalFruit(int[] tree) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int ans = 0, l = 0, r = 0;
            while (r < tree.length) {
                map.put(tree[r], map.getOrDefault(tree[r], 0) + 1);
                r++;
                
                if(map.size() <= 2) ans = Math.max(ans, r - l);
                
                while (map.size() > 2) {
                    map.put(tree[l], map.get(tree[l]) - 1);
                    if (map.get(tree[l]) == 0) 
                        map.remove(tree[l]);
                    l++;
                }
                
            }
            return ans;
        }
}
class Solution {   
  public int maxProduct(String[] words) {
    Map<Integer, Integer> hashmap = new HashMap();

    for (String word : words) {
      int bitmask = 0;
      for (char c : word.toCharArray()) {
        bitmask |= 1 << (c - 'a');
      }
        
      hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
    }

    int ans = 0;
    for (int x : hashmap.keySet())
      for (int y : hashmap.keySet())
        if ((x & y) == 0) ans = Math.max(ans, hashmap.get(x) * hashmap.get(y));

    return ans;
  }
}
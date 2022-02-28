//Binary Search
class Solution {
    private List<List<Integer>> idx;
    
    public int numMatchingSubseq(String S, String[] words) {
      idx = new ArrayList<>();
      for (int i = 0; i < 128; ++i) 
        idx.add(new ArrayList<Integer>());
      char[] s = S.toCharArray();
      for (int i = 0; i < s.length; ++i)
        idx.get(s[i]).add(i);
      int ans = 0;
      for (String word : words)
        if (isSubsequence(word)) ans++;
      return ans;
    }

    private boolean isSubsequence(String word) {
        int l = -1;
        for (char c : word.toCharArray()) {
          List<Integer> p = idx.get(c);
          int index = Collections.binarySearch(p, l + 1);
          if (index < 0) index = -index - 1;
          if (index >= p.size()) return false;
          l = p.get(index);
        }
        return true;
      }
  }
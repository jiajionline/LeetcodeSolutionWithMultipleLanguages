//bidirectional BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), wordSet = new HashSet<>(wordList);
      if (!wordSet.contains(endWord)) return 0;
      
      beginSet.add(beginWord);
      endSet.add(endWord);
      
      int N = beginWord.length();
      int steps = 0;
      
      while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        ++steps;
        
        if (beginSet.size() > endSet.size()) {
          Set<String> tmp = beginSet;
          beginSet = endSet;
          endSet = tmp;
        }
        
        Set<String> nextSet = new HashSet<>();
        
        for (String w : beginSet) {        
          char[] chaArr = w.toCharArray();
          for (int i = 0; i < N; ++i) {
            char ch = chaArr[i];
            for (char c = 'a'; c <= 'z'; ++c) {
              chaArr[i] = c;
              String t = new String(chaArr);         
              if (endSet.contains(t)) return steps + 1;            
              if (!wordSet.contains(t)) continue;            
              wordSet.remove(t);        
              nextSet.add(t);
            }
            chaArr[i] = ch;
          }
        }
        
        beginSet = nextSet;
      }
      return 0;
    }
  }
import java.util.HashSet;
import java.util.Set;

//bidirectional BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> wordSet = new HashSet<>(wordList);
      
      if (!wordSet.contains(endWord)) return 0;
      
      Set<String> q1 = new HashSet<>();
      Set<String> q2 = new HashSet<>();
      q1.add(beginWord);
      q2.add(endWord);
      
      int l = beginWord.length();
      int steps = 0;
      
      while (!q1.isEmpty() && !q2.isEmpty()) {
        ++steps;
        
        if (q1.size() > q2.size()) {
          Set<String> tmp = q1;
          q1 = q2;
          q2 = tmp;
        }
        
        Set<String> q = new HashSet<>();
        
        for (String w : q1) {        
          char[] chaArr = w.toCharArray();
          for (int i = 0; i < l; ++i) {
            char ch = chaArr[i];
            for (char c = 'a'; c <= 'z'; ++c) {
              chaArr[i] = c;
              String t = new String(chaArr);         
              if (q2.contains(t)) return steps + 1;            
              if (!wordSet.contains(t)) continue;            
              wordSet.remove(t);        
              q.add(t);
            }
            chaArr[i] = ch;
          }
        }
        
        q1 = q;
      }
      return 0;
    }
  }
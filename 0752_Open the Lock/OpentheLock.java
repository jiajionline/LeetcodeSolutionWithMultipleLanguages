class Solution {
    public int openLock(String[] deadends, String target) {
      String start = "0000";
      if(start.equals(target)) return 0;
        
      Set<String> deadendSet = new HashSet();
      for (String d: deadends) deadendSet.add(d);
      if (deadendSet.contains(start)) return -1;
   
      Queue<String> queue = new LinkedList();
      queue.offer(start);        
   
      Set<String> visited = new HashSet();
      visited.add(start);
   
      int steps = 0;
      while (!queue.isEmpty()) {
        ++steps;
        int s = queue.size();
        while(s-- > 0){
          String currLock = queue.poll();
          for (int i = 0; i < 4; ++i) {
            for (int j = -1; j <= 1; j += 2) {
              char[] chars = currLock.toCharArray();
              chars[i] = (char)(((chars[i] - '0') + j + 10) % 10 + '0');
              String nextLock = new String(chars);
              if (nextLock.equals(target)) return steps;
              if (deadendSet.contains(nextLock) || visited.contains(nextLock))
                  continue;
              visited.add(nextLock);
              queue.offer(nextLock);
            }
          }
        }
      }
      return -1;
    }
  }
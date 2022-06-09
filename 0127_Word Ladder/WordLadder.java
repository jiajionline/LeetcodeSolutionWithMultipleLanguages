class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>(wordList);
        if(!set.contains(endWord) || beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int step = 0, N = beginWord.length();
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while(size-- > 0) {
                String cur = queue.poll();
                if(cur.equals(endWord)) return step;
                char[] chs = cur.toCharArray();
                for(int i=0;i<N;i++) {
                    char ch = chs[i];
                    for(char c = 'a'; c<= 'z';c++) {
                        if(c == ch) continue;
                        chs[i] = c;
                        String str = new String(chs);
                        if(set.contains(str)) {
                            queue.offer(str);
                            set.remove(str);  
                        }
                        chs[i] = ch;
                    }
                }
                
            }
        }
        
        return 0;
    }
}
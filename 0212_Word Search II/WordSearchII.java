class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        if(board == null || words == null) return ans;
        int[] dirs = new int[]{0,1,0,-1,0};
        Trie root = buildTrie(words);
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                Trie p = root;
                DFS(board, p, i, j, dirs, ans);
            }
        }
        
        return ans;
    }
    
    private void DFS(char[][] board, Trie p, int x, int y, int[] dirs, List<String> ans) {
        if(x < 0 || y < 0 || x == board.length || y == board[x].length || board[x][y] == '#') return;
        char c = board[x][y];
        if(p.next[c-'a'] == null) return;
        if(p.next[c-'a'].word != null) {
            ans.add(p.next[c-'a'].word);
            p.next[c-'a'].word = null;
        }
        
        board[x][y] = '#';
        for(int i=0;i<4;i++) {
            int dx = x + dirs[i];
            int dy = y + dirs[i+1];
            DFS(board, p.next[c-'a'], dx, dy, dirs, ans);
        }
        
        board[x][y] = c;
        
    }
    
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            Trie p = root;
            for(char c : word.toCharArray()) {
                if(p.next[c-'a'] == null) p.next[c-'a'] = new Trie();
                p = p.next[c-'a'];
            }
            
            p.word = word;
        }
        
        return root;
    }
}

class Trie {
    Trie[] next = new Trie[26];
    String word;
}
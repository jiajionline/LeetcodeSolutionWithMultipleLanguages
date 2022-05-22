class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> ans = new LinkedList<>();
        if(m == 0) return ans;
        int[] dirs = {0,1,0,-1,0};
        TrieNode root = buildTrie(words);
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                Trie p = root;
                DFS(board, p, i, j, m, n, dirs, ans);
            }
        }
        
        return ans;
    }
    
    private void DFS(char[][] board, Trie p, int x, int y, int m, int n, int[] dirs, List<String> ans) {
        if(x < 0 || y < 0 || x == m || y == n || board[x][y] == '#') return;
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
            DFS(board, p.next[c-'a'], dx, dy, m, n, dirs, ans);
        }
        
        board[x][y] = c;
        
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                if(p.next[c-'a'] == null) p.next[c-'a'] = new Trie();
                p = p.next[c-'a'];
            }
            
            p.word = word;
        }
        
        return root;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
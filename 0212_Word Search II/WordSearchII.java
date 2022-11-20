class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> ans = new LinkedList<>();
        if(m == 0) return ans;
        Trie root = buildTrie(words);
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                Trie p = root;
                DFS(board, p, i, j, m, n, ans);
            }
        }
        
        return ans;
    }
    
    private void DFS(char[][] board, Trie p, int x, int y, int m, int n, List<String> ans) {
        if(x < 0 || y < 0 || x == m || y == n || board[x][y] == '#') return;
        char c = board[x][y];
        if(p.next[c-'a'] == null) return;
        if(p.next[c-'a'].word != null) {
            ans.add(p.next[c-'a'].word);
            p.next[c-'a'].word = null;
        }
        
        board[x][y] = '#';
        DFS(board, p.next[c-'a'], x -1, y, m, n, ans);
        DFS(board, p.next[c-'a'], x +1, y, m, n, ans);
        DFS(board, p.next[c-'a'], x, y-1, m, n, ans);
        DFS(board, p.next[c-'a'], x, y+1, m, n, ans);
        
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
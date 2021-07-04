public class Solution {
    public IList<string> FindWords(char[][] board, string[] words) {
        var ans = new List<string>();
        if(board == null || board.Length == 0 || words == null || words.Length == 0) return ans;
        
        var root = BuildTrie(words);
        
        for(int i=0;i<board.Length;i++){
            for(int j=0;j<board[i].Length;j++)
            {
                DFS(board, i, j, root, ans);
            }
        }
        
        return ans;
        
    }
    
    private void DFS(char[][] board, int x, int y, Trie trie, IList<string> ans)
    {
        if(x < 0 || y <0 || x >= board.Length || y >= board[x].Length || board[x][y] == '#') return;
        var c = board[x][y];
        var nextTrie = trie.Next[c - 'a'];
        if(nextTrie == null) return;
        
        if(nextTrie.Word != null){
            ans.Add(nextTrie.Word);
            nextTrie.Word = null;
        }
        
        board[x][y] = '#';
        DFS(board, x-1, y, nextTrie, ans);
        DFS(board, x+1, y, nextTrie, ans);
        DFS(board, x, y-1, nextTrie, ans);
        DFS(board, x, y+1, nextTrie, ans);
        board[x][y] = c;
        
    }

    private Trie BuildTrie(string[] words)
    {
        var root = new Trie();
        foreach(var w in words)
        {
            var p = root;
            foreach(var c in w)
            {
                if((p.Next[c-'a']) == null) p.Next[c-'a'] = new Trie();
                p = p.Next[c-'a'];
            }
            
            p.Word = w;
        }
        
        return root;
    }
}


public class Trie
{
    public Trie[] Next = new Trie[26];
    public string Word;
}
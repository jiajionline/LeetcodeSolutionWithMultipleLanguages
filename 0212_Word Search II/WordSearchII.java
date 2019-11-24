import java.util.LinkedList;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        if(board == null || words == null) return ans;
        Trie root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                DFS(board, i, j, root,ans);
            }
        }

        return ans;
    }

    private void DFS(char[][] board,int x, int y,Trie root, List<String> ans){
        if(x<0 || y<0 || x>=board.length || y>= board[x].length || board[x][y] == '#') return;
        char c = board[x][y];
        if(root.next==null || root.next[c-'a']==null) return;
        if(root.next[c-'a'].word!=null){
            ans.add(root.next[c-'a'].word);
            root.next[c-'a'].word = null;
        }
        board[x][y] = '#';
        DFS(board, x-1, y, root.next[c-'a'], ans);
        DFS(board, x, y-1, root.next[c-'a'], ans);
        DFS(board, x+1, y, root.next[c-'a'], ans);
        DFS(board, x, y+1, root.next[c-'a'], ans);
        board[x][y] = c;
    }

    private Trie buildTrie(String[] words){
        Trie root = new Trie();
        for (String w : words) {
            Trie p = root;
            for (char c : w.toCharArray()) {
                if(p.next[c-'a'] == null){
                    p.next[c-'a'] = new Trie();
                }

                p = p.next[c-'a'];
            }

            p.word = w;
        }
        return root;
    }
}

public class Trie{
    Trie[] next = new Trie[26];
    String word;
}
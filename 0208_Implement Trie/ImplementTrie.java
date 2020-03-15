class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    // Initialize your data structure here.
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ws.children[ch - 'a'] == null){
                ws.children[ch - 'a'] = new TrieNode();
            }
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ws = searchHelper(word);
        return ws != null && ws.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
         return searchHelper(prefix) != null;
    }
    
    public TrieNode searchHelper(String key){
        TrieNode ws = root;
        for(int i = 0; i < key.length() && ws != null; i++){
            char ch = key.charAt(i);
            ws = ws.children[ch - 'a'];
        }
        return ws;
    }
}
